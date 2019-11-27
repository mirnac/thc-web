package com.treshermanas.thcweb.model;

import com.treshermanas.thcweb.beans.products.StockVerificationItem;
import com.treshermanas.thcweb.beans.products.VerificationStatus;
import com.treshermanas.thcweb.beans.products.Warehouse;

import java.util.Date;
import java.util.List;

public class StockVerificationModel {

    private String uuid;
    private Date startDate;
    private String userName;
    private String product;
    private Warehouse warehouse;
    private VerificationStatus status;
    private List<StockVerificationItem> items;

    public StockVerificationModel(){

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public VerificationStatus getStatus() {
        return status;
    }

    public void setStatus(VerificationStatus status) {
        this.status = status;
    }

    public List<StockVerificationItem> getItems() {
        return items;
    }

    public void setItems(List<StockVerificationItem> items) {
        this.items = items;
    }
}
