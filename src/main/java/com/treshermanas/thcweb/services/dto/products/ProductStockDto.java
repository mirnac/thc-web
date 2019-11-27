package com.treshermanas.thcweb.services.dto.products;

public class ProductStockDto {

    private ProductDto product;
    private Integer warehouse;
    private Integer quantity;

    public ProductStockDto(){

    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public Integer getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Integer warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
