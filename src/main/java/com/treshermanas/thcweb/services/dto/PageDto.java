package com.treshermanas.thcweb.services.dto;

import java.io.Serializable;
import java.util.List;

public class PageDto<T> implements Serializable {

    private Integer number;
    private List<T> data;
    private Integer pageSize;
    private Integer totalPagesCount;

    public PageDto(Integer number, Integer pageSize) {
        this.number = number;
        this.pageSize = pageSize;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPagesCount() {
        return totalPagesCount;
    }

    public void setTotalPagesCount(Integer totalPagesCount) {
        this.totalPagesCount = totalPagesCount;
    }

    public static class Builder<T> {

        private Integer number;
        private List<T> data;
        private Integer pageSize;
        private Integer totalPagesCount;

        private Builder(Integer number, Integer pageSize) {
            this.number = number;
            this.pageSize = pageSize;
        }

        public static Builder builder(Integer pageNumber, Integer pageSize) {
            return new Builder(pageNumber, pageSize);
        }

        public Builder withData(List<T> data) {
            this.data = data;
            return this;
        }

        public Builder withTotalCount(Integer count) {
            this.totalPagesCount = count;
            return this;
        }

        public PageDto<T> build() {
            PageDto<T> pageDto = new PageDto<>(number, pageSize);
            pageDto.setData(data);
            pageDto.setTotalPagesCount(totalPagesCount);
            return pageDto;
        }
    }
}
