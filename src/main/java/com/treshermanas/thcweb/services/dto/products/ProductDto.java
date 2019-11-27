package com.treshermanas.thcweb.services.dto.products;

import java.math.BigDecimal;

public class ProductDto {

    private String ref;
    private String label;
    private String description;
    private BigDecimal price;
    private BigDecimal priceTtc;
    private BigDecimal priceMinTtc;
    private String priceBaseType;

    public ProductDto(){

    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceTtc() {
        return priceTtc;
    }

    public void setPriceTtc(BigDecimal priceTtc) {
        this.priceTtc = priceTtc;
    }

    public BigDecimal getPriceMinTtc() {
        return priceMinTtc;
    }

    public void setPriceMinTtc(BigDecimal priceMinTtc) {
        this.priceMinTtc = priceMinTtc;
    }

    public String getPriceBaseType() {
        return priceBaseType;
    }

    public void setPriceBaseType(String priceBaseType) {
        this.priceBaseType = priceBaseType;
    }
}
