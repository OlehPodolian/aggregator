package oleg.podolian.demo.dao.impl;

import oleg.podolian.demo.dao.BankDao;
import oleg.podolian.demo.model.Bank;
import oleg.podolian.demo.model.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class BankDaoImpl implements BankDao {

    private static final Logger logger = LoggerFactory.getLogger(BankDaoImpl.class);
    private static final String TABLE_NAME = "BANKS";
    private static final String BANK_ID = "bank_id";
    private static final String BANK_NAME = "name";
    private static final String SELECT_ALL = "SELECT B.bank_id as b_id, B.NAME as bank_name,  C.NAME as cur_name, " +
                                                " C.BUY_RATE as buy, C.SELL_RATE as sell " +
                                                " FROM CURRENCIES C " +
                                                " LEFT JOIN BANKS B on C.BANK_ID = B.BANK_ID " +
                                                " WHERE B.NAME = :bankName ";

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Autowired
    public BankDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Bank save(Bank bank) {
        try {
            String sql = "INSERT INTO " + TABLE_NAME + "(" + BANK_NAME + ") VALUES (:bankName);";
            MapSqlParameterSource params = new MapSqlParameterSource()
                    .addValue("bankName", bank.getName());
            KeyHolder keyHolder = new GeneratedKeyHolder();
            int bankId = namedParameterJdbcTemplate.update(sql, params, keyHolder);
            bank.setBankId(bankId);
            return bank;
        } catch (Exception e) {
            logger.info("Bank with name {} already stored", bank.getName());
            return findByName(bank.getName()).get();
        }
    }

    @Override
    public Optional<Bank> findByName(String bankName) {
        try {
            String sql = SELECT_ALL + " WHERE B.NAME = :bankName";
            MapSqlParameterSource params = new MapSqlParameterSource()
                    .addValue("bankName", bankName);
            return Optional.of(namedParameterJdbcTemplate.query(sql, params, bankResultSetExtractor()));
        } catch (Exception e) {
            logger.info("Bank with name {} not found", bankName);
            return Optional.empty();
        }
    }

    @Override
    public boolean delete(Bank bank) {
        try {
            String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + BANK_NAME + " = :bankName";
            MapSqlParameterSource params = new MapSqlParameterSource()
                    .addValue("bankName", bank.getName());
            namedParameterJdbcTemplate.update(sql, params);
            return true;
        } catch (Exception e) {
            logger.info("Failed to delete bank with name: {}", bank.getName());
            return false;
        }
    }

    private RowMapper<Bank> rowMapper() {
        return (rs, i) -> new Bank(rs.getInt(BANK_ID), rs.getString(BANK_NAME));
    }

    private ResultSetExtractor<Bank> bankResultSetExtractor() {
        return rs -> {
            Bank bank = new Bank(rs.getInt("b_id"),
                    rs.getString("BANK_NAME"));
            while (rs.next()) {
                Currency currency = new Currency();
                currency.setBank(bank);
                currency.setCurrencyName(rs.getString("CUR_NAME"));
                currency.setBuyRate(rs.getBigDecimal("BUY"));
                currency.setSellRate(rs.getBigDecimal("SELL"));
                bank.getCurrencies().add(currency);
            }
            return bank;
        };
    }
}
