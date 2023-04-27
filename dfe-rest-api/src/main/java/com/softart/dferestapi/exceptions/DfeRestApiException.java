package com.softart.dferestapi.exceptions;

public class DfeRestApiException extends RuntimeException {

    public DfeRestApiException() {
    }

    public DfeRestApiException(String message) {
        super(message);
    }

    public DfeRestApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public DfeRestApiException(Throwable cause) {
        super(cause);
    }

    public DfeRestApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
