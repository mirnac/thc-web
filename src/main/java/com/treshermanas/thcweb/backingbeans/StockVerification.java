package com.treshermanas.thcweb.backingbeans;

import com.treshermanas.thcweb.beans.products.StockVerificationItem;
import com.treshermanas.thcweb.beans.products.VerificationStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StockVerification {

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date startDate;
    private String userName;
    private String uuid;
    private String product;
    private Integer warehouse;
    private Integer pendingVerificationCount;
    private VerificationStatus status;

    private List<StockVerificationItem> items;
    public StockVerification(){
        status = VerificationStatus.NOT_STARTED;
        startDate = Calendar.getInstance().getTime();
        items = new ArrayList<>();
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

    public List<StockVerificationItem> getItems() {
        return items;
    }

    public void setItems(List<StockVerificationItem> items) {
        this.items = items;
    }

    public Integer getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Integer warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getPendingVerificationCount() {
        return pendingVerificationCount;
    }

    public void setPendingVerificationCount(Integer pendingVerificationCount) {
        this.pendingVerificationCount = pendingVerificationCount;
    }

    public VerificationStatus getStatus() {
        return status;
    }

    public void setStatus(VerificationStatus status) {
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
