package com.treshermanas.thcweb.beans.products;

import java.math.BigDecimal;

public class Product {

    private String ref;
    private String label;
    private String description;
    private BigDecimal unitPriceTaxExcl;
    private BigDecimal unitPriceTaxIncl;
    private BigDecimal minPriceTaxExcl;
    private BigDecimal minPriceTaxIncl;
    private BigDecimal threeInstPrice;
    private String priceBaseType;

    public Product() {

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

    public BigDecimal getUnitPriceTaxExcl() {
        return unitPriceTaxExcl;
    }

    public void setUnitPriceTaxExcl(BigDecimal unitPriceTaxExcl) {
        this.unitPriceTaxExcl = unitPriceTaxExcl;
    }

    public BigDecimal getUnitPriceTaxIncl() {
        return unitPriceTaxIncl;
    }

    public void setUnitPriceTaxIncl(BigDecimal unitPriceTaxIncl) {
        this.unitPriceTaxIncl = unitPriceTaxIncl;
    }

    public BigDecimal getMinPriceTaxIncl() {
        return minPriceTaxIncl;
    }

    public void setMinPriceTaxIncl(BigDecimal minPriceTaxIncl) {
        this.minPriceTaxIncl = minPriceTaxIncl;
    }

    public String getPriceBaseType() {
        return priceBaseType;
    }

    public void setPriceBaseType(String priceBaseType) {
        this.priceBaseType = priceBaseType;
    }

    public BigDecimal getMinPriceTaxExcl() {
        return minPriceTaxExcl;
    }

    public void setMinPriceTaxExcl(BigDecimal minPriceTaxExcl) {
        this.minPriceTaxExcl = minPriceTaxExcl;
    }

    public BigDecimal getThreeInstPrice() {
        return threeInstPrice;
    }

    public void setThreeInstPrice(BigDecimal threeInstPrice) {
        this.threeInstPrice = threeInstPrice;
    }
}
