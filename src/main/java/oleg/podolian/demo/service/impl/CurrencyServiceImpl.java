package oleg.podolian.demo.service.impl;

import oleg.podolian.demo.dao.BankDao;
import oleg.podolian.demo.dao.CurrencyDao;
import oleg.podolian.demo.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyDao currencyDao;
    private final BankDao bankDao;

    @Autowired
    public CurrencyServiceImpl(CurrencyDao currencyDao, BankDao bankDao) {
        this.currencyDao = currencyDao;
        this.bankDao = bankDao;
    }

    public void main(String[] args) {
        bankDao.findByName("Grigoriy");
    }
}
