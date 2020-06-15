package com.treshermanas.thcweb.beans.invoice.customers;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OverdueSummary {

    private BigDecimal amount;
    private LocalDate date;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
