package com.treshermanas.thcweb.backingbeans.invoices.customer;

import com.treshermanas.thcweb.beans.thirdperson.ThirdPerson;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Invoice {

    private Integer id;
    private String facNumber;
    private ThirdPerson customer;
    private BigDecimal overduePenalty;
    private LocalDate lastPaymentDate;
    private LocalDate dueDate;
    private BigDecimal pendingBalance;
    private PaymentTerm paymentTerm;

    public Invoice(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFacNumber() {
        return facNumber;
    }

    public void setFacNumber(String facNumber) {
        this.facNumber = facNumber;
    }

    public ThirdPerson getCustomer() {
        return customer;
    }

    public void setCustomer(ThirdPerson customer) {
        this.customer = customer;
    }

    public PaymentTerm getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(PaymentTerm paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public BigDecimal getOverduePenalty() {
        return overduePenalty;
    }

    public void setOverduePenalty(BigDecimal overduePenalty) {
        this.overduePenalty = overduePenalty;
    }

    public LocalDate getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(LocalDate lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public BigDecimal getPendingBalance() {
        return pendingBalance;
    }

    public void setPendingBalance(BigDecimal pendingBalance) {
        this.pendingBalance = pendingBalance;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
