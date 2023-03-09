package com.softart.dferestapi.exceptions;

public class DfeRestException extends RuntimeException {

    public DfeRestException() {
    }

    public DfeRestException(String message) {
        super(message);
    }

    public DfeRestException(String message, Throwable cause) {
        super(message, cause);
    }

    public DfeRestException(Throwable cause) {
        super(cause);
    }

    public DfeRestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
