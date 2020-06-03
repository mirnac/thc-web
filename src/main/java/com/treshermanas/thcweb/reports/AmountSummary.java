package com.treshermanas.thcweb.reports;

import java.math.BigDecimal;

public class AmountSummary {

    private Integer number;
    private BigDecimal amount;

    public AmountSummary(){

    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
