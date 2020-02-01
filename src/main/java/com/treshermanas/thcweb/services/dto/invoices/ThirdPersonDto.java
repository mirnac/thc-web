package com.treshermanas.thcweb.services.dto.invoices;

public class ThirdPersonDto {

    private String name;
    private String documentNumber;

    public ThirdPersonDto(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
