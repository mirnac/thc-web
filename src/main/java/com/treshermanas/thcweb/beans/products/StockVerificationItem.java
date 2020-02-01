package com.treshermanas.thcweb.beans.products;

import java.io.Serializable;

public class StockVerificationItem implements Serializable {

    private Integer id;
    private ProductStock productStock;
    private Integer currentCount;

    public StockVerificationItem() {
    }

    public StockVerificationItem(ProductStock productStock) {
        this();
        this.productStock = productStock;
    }

    public StockVerificationItem(ProductStock productStock, Integer currentCount) {
        this.productStock = productStock;
        this.currentCount = currentCount;
    }

    public ProductStock getProductStock() {
        return productStock;
    }

    public void setProductStock(ProductStock productStock) {
        this.productStock = productStock;
    }

    public Integer getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
