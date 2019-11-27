package com.treshermanas.thcweb.services.stock.requests;

import javax.validation.constraints.NotNull;

public class StockVerificationReq {

    private String name;
    private Integer pageSize;
    @NotNull
    private Integer pageNumber;
    @NotNull
    private Integer warehouse;
    @NotNull
    private String userName;
    public StockVerificationReq(){

    }

    public StockVerificationReq(Integer warehouse){
        this.warehouse = warehouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Integer warehouse) {
        this.warehouse = warehouse;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static class Builder{

        private String name;
        private Integer pageSize;
        private Integer pageNumber;
        private Integer warehouse;
        private String userName;

        private Builder(Integer warehouse, String userName){
            this.warehouse = warehouse;
            this.userName = userName;
        }

        public static Builder builder(Integer warehouse, String userName){
            return new Builder(warehouse, userName);
        }

        public Builder withName(String name){
            this.name = name;
            return this;
        }
        public Builder withPageNumber(Integer pageNumber){
            this.pageNumber = pageNumber;
            return this;
        }
        public Builder withPageSize(Integer pageSize){
            this.pageSize = pageSize;
            return this;
        }
        public StockVerificationReq build(){
             StockVerificationReq req = new StockVerificationReq(warehouse);

             req.setName(name);
             req.setPageNumber(pageNumber);
             req.setPageSize(pageSize);
             req.setUserName(userName);
             return req;
        }
    }
}
