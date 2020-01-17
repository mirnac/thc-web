package com.treshermanas.thcweb.services.dto.products;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonIgnoreProperties
public class ProductDto {

    private String ref;
    private String label;
    private String description;
    private BigDecimal unitPriceTaxExcl;
    private BigDecimal unitPriceTaxIncl;
    private BigDecimal minPriceTaxExcl;
    private BigDecimal minPriceTaxIncl;
    private BigDecimal threeInstPrice;
    private String priceBaseType;
    private LocalDateTime lastPriceVerif;


    public ProductDto() {

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

    public String getPriceBaseType() {
        return priceBaseType;
    }

    public void setPriceBaseType(String priceBaseType) {
        this.priceBaseType = priceBaseType;
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

    public BigDecimal getMinPriceTaxExcl() {
        return minPriceTaxExcl;
    }

    public void setMinPriceTaxExcl(BigDecimal minPriceTaxExcl) {
        this.minPriceTaxExcl = minPriceTaxExcl;
    }

    public BigDecimal getMinPriceTaxIncl() {
        return minPriceTaxIncl;
    }

    public void setMinPriceTaxIncl(BigDecimal minPriceTaxIncl) {
        this.minPriceTaxIncl = minPriceTaxIncl;
    }

    public BigDecimal getThreeInstPrice() {
        return threeInstPrice;
    }

    public void setThreeInstPrice(BigDecimal threeInstPrice) {
        this.threeInstPrice = threeInstPrice;
    }

    public LocalDateTime getLastPriceVerif() {
        return lastPriceVerif;
    }

    public void setLastPriceVerif(LocalDateTime lastPriceVerif) {
        this.lastPriceVerif = lastPriceVerif;
    }
}
