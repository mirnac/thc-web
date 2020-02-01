package com.treshermanas.thcweb.services.dto.products;

import java.io.Serializable;

public class StockVerificationItemDto implements Serializable {

    private Integer id;
    private ProductStockDto productStock;
    private Integer currentCount;

    public StockVerificationItemDto() {
    }

    public StockVerificationItemDto(ProductStockDto productStock) {
        this.productStock = productStock;
    }

    public StockVerificationItemDto(ProductStockDto productStock, Integer currentCount) {
        this.productStock = productStock;
        this.currentCount = currentCount;
    }

    public ProductStockDto getProductStock() {
        return productStock;
    }

    public void setProductStock(ProductStockDto productStock) {
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
