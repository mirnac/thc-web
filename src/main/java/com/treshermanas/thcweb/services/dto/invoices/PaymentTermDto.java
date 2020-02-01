package com.treshermanas.thcweb.services.dto.invoices;

public class PaymentTermDto {

    private String code;
    private String label;

    public PaymentTermDto(){

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
