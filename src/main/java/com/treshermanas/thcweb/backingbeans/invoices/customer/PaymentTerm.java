package com.treshermanas.thcweb.backingbeans.invoices.customer;

public class PaymentTerm {

    private String code;
    private String label;

    public PaymentTerm(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}