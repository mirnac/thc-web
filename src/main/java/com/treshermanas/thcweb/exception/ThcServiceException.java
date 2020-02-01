package com.treshermanas.thcweb.exception;

public class ThcServiceException extends RuntimeException {

    public ThcServiceException() {
    }

    public ThcServiceException(String message) {
        super(message);
    }

    public ThcServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThcServiceException(Throwable cause) {
        super(cause);
    }

    public ThcServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
