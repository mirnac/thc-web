package com.treshermanas.thcweb.services.dto.products;

import com.treshermanas.thcweb.beans.products.VerificationStatus;
import com.treshermanas.thcweb.services.dto.PageDto;

import java.util.Date;

public class StockVerificationDto {

    private String uuid;
    private Date startDate;
    private Date endDate;
    private VerificationStatus status;
    private PageDto<StockVerificationItemDto> page;

    public StockVerificationDto() {

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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public VerificationStatus getStatus() {
        return status;
    }

    public void setStatus(VerificationStatus status) {
        this.status = status;
    }


    public PageDto<StockVerificationItemDto> getPage() {
        return page;
    }

    public void setPage(PageDto<StockVerificationItemDto> page) {
        this.page = page;
    }
}
