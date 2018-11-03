package oleg.podolian.demo.dao;

import oleg.podolian.demo.model.Bank;

import java.util.List;
import java.util.Optional;

public interface BankDao {

    Bank save (Bank bank);

    Optional<Bank> findByName(String name);

    boolean delete(Bank bank);

}
