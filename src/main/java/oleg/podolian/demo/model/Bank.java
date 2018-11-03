package oleg.podolian.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private int bankId;
    private String name;

    private List<Currency> currencies = new ArrayList<>();
    public Bank() { }

    public Bank(int bankId, String name) {
        this.bankId = bankId;
        this.name = name;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
