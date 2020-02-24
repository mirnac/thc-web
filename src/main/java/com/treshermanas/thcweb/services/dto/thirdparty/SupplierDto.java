package com.treshermanas.thcweb.services.dto.thirdparty;

public class SupplierDto extends  ThirdPersonDto {

    private String supplierCode;

    public SupplierDto(){

    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }
}
