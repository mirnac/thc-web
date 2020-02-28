package com.treshermanas.thcweb.services.dto.invoices;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SupplierInvoiceDto {

    private String facNumber;
    private String refExt;
    private BigDecimal totalTva;
    private LocalDate datef;

    public SupplierInvoiceDto(){

    }

    public String getFacNumber() {
        return facNumber;
    }

    public void setFacNumber(String facNumber) {
        this.facNumber = facNumber;
    }

    public String getRefExt() {
        return refExt;
    }

    public void setRefExt(String refExt) {
        this.refExt = refExt;
    }

    public BigDecimal getTotalTva() {
        return totalTva;
    }

    public void setTotalTva(BigDecimal totalTva) {
        this.totalTva = totalTva;
    }

    public LocalDate getDatef() {
        return datef;
    }

    public void setDatef(LocalDate datef) {
        this.datef = datef;
    }
}
