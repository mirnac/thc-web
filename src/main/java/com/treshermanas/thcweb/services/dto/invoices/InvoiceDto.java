package com.treshermanas.thcweb.services.dto.invoices;

import com.treshermanas.thcweb.services.dto.thirdparty.ThirdPersonDto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InvoiceDto {

    private String facNumber;
    private ThirdPersonDto thirdPerson;
    private LocalDate invoiceDate;
    private BigDecimal totalTaxIncluded;
    private PaymentTermDto paymentTerm;

    public InvoiceDto(){

    }

    public String getFacNumber() {
        return facNumber;
    }

    public void setFacNumber(String facNumber) {
        this.facNumber = facNumber;
    }

    public ThirdPersonDto getThirdPerson() {
        return thirdPerson;
    }

    public void setThirdPerson(ThirdPersonDto thirdPerson) {
        this.thirdPerson = thirdPerson;
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
}
