package com.softart.dfe.exceptions;

/**
 * This exception is thrown when a required field is missing
 */
public class RequiredException extends RuntimeException {

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
