package com.treshermanas.thcweb.services.dto.invoices;

import com.treshermanas.thcweb.services.dto.thirdparty.ThirdPersonDto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InvoiceDto {

    private Integer id;
    private String facNumber;
    private ThirdPersonDto customer;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private BigDecimal overduePenalty;
    private LocalDate lastPaymentDate;
    private BigDecimal pendingBalance;
    private BigDecimal totalTaxIncluded;
    private PaymentTermDto paymentTerm;

    public InvoiceDto(){

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

    public ThirdPersonDto getCustomer() {
        return customer;
    }

    public void setCustomer(ThirdPersonDto customer) {
        this.customer = customer;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getTotalTaxIncluded() {
        return totalTaxIncluded;
    }

    public void setTotalTaxIncluded(BigDecimal totalTaxIncluded) {
        this.totalTaxIncluded = totalTaxIncluded;
    }

    public PaymentTermDto getPaymentTerm() {
        return paymentTerm;
    }

    public void setPaymentTerm(PaymentTermDto paymentTerm) {
        this.paymentTerm = paymentTerm;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
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
}
