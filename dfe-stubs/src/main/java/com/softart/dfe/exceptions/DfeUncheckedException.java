package com.softart.dfe.exceptions;

/**
 * `DFUncheckedException` is a `RuntimeException` that can be thrown by a `DFProcessor` when it encounters an error
 */
public class DfeUncheckedException extends RuntimeException {

    public DfeUncheckedException() {
    }

    public DfeUncheckedException(String message) {
        super(message);
    }

    public DfeUncheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DfeUncheckedException(Throwable cause) {
        super(cause);
    }

    public DfeUncheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
