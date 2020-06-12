package com.treshermanas.thcweb.beans;

import java.math.BigDecimal;

public class DataElement {

    private Integer number;
    private BigDecimal amount;

    public DataElement(){

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
