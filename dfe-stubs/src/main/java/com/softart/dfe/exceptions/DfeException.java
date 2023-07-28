package com.softart.dfe.exceptions;

/**
 * DFException is a subclass of Exception that adds nothing.
 */
public class DfeException extends Exception {
    public DfeException() {
    }

    public DfeException(String message) {
        super(message);
    }

    public DfeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DfeException(Throwable cause) {
        super(cause);
    }

    public DfeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
