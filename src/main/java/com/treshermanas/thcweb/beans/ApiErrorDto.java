package com.treshermanas.thcweb.beans;

public class ApiErrorDto {

    private Integer errorIid;
    private String errorCode;
    private String errorMessage;

    public ApiErrorDto() {

    }

    public Integer getErrorIid() {
        return errorIid;
    }

    public void setErrorIid(Integer errorIid) {
        this.errorIid = errorIid;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ApiErrorDto{" +
                "errorIid=" + errorIid +
                ", errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
