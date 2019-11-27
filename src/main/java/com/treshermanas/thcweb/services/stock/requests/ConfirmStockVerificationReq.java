package com.treshermanas.thcweb.services.stock.requests;


import com.treshermanas.thcweb.services.dto.products.StockVerificationItemDto;

import java.util.ArrayList;
import java.util.List;

public class ConfirmStockVerificationReq {

    private String uuid;
    private List<StockVerificationItemDto> verificationItems;

    public ConfirmStockVerificationReq(){
        verificationItems = new ArrayList<>();
    }

    public ConfirmStockVerificationReq(String uuid, List<StockVerificationItemDto> verificationItems) {
        this.uuid = uuid;
        this.verificationItems = verificationItems;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<StockVerificationItemDto> getVerificationItems() {
        return verificationItems;
    }

    public void setVerificationItems(List<StockVerificationItemDto> verificationItems) {
        this.verificationItems = verificationItems;
    }
}
