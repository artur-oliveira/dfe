package com.softart.dfe.exceptions;

public class RequiredException extends DFUncheckedException {

    public RequiredException() {
    }

    public RequiredException(String message) {
        super(message);
    }

    public RequiredException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequiredException(Throwable cause) {
        super(cause);
    }

    public RequiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
