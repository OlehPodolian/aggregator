package oleg.podolian.demo.model;

import java.math.BigDecimal;

public class Currency {

    private Bank bank;
    private String currencyName;
    private BigDecimal buyRate;
    private BigDecimal sellRate;

    public Currency() {
    }

    public Currency(String currencyName, BigDecimal buyRate, BigDecimal sellRate) {
        this.currencyName = currencyName;
        this.buyRate = buyRate;
        this.sellRate = sellRate;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public BigDecimal getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(BigDecimal buyRate) {
        this.buyRate = buyRate;
    }

    public BigDecimal getSellRate() {
        return sellRate;
    }

    public void setSellRate(BigDecimal sellRate) {
        this.sellRate = sellRate;
    }
}
