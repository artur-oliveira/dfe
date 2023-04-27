package com.softart.dfe.exceptions;

/**
 * DFException is a subclass of Exception that adds nothing.
 */
public class DFException extends Exception {
    public DFException() {
    }

    public DFException(String message) {
        super(message);
    }

    public DFException(String message, Throwable cause) {
        super(message, cause);
    }

    public DFException(Throwable cause) {
        super(cause);
    }

    public DFException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
