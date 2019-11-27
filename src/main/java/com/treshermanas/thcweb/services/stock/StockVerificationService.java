package com.treshermanas.thcweb.services.stock;

import com.treshermanas.thcweb.beans.products.StockVerificationItem;
import com.treshermanas.thcweb.model.StockVerificationModel;

import java.util.List;

public interface StockVerificationService {

    int PAGE_NUMBER = 1;

    String GET_PENDING_COUNT_PATH        = "/productos/stock/pending_verification/count/%d";
    String GET_PENDING_VERIFICATION_PATH = "/productos/stock/pending_verification/%d?pageSize=%d&pageNumber=1";
    String POST_START_VERIFICATION_PATH  = "/productos/stock/verification";
    String PATCH_VERIFICATION_CANCEL     = "/productos/stock/verification/%s/status/cancel";
    String PUT_VERIFICATION              = "/productos/stock/verification";

    Integer getPendingVerificationCount(Integer warehouse);
    List<StockVerificationItem> pendingVerificationProducts(Integer warehouse, String productDesc);
    StockVerificationModel startVerification(Integer warehouse, String userName, String product);
    void cancelVerification(String uuid);
    void saveVerification(String uuid, List<StockVerificationItem> items);
}
