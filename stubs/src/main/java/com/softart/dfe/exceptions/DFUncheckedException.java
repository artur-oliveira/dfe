package com.softart.dfe.exceptions;

/**
 * `DFUncheckedException` is a `RuntimeException` that can be thrown by a `DFProcessor` when it encounters an error
 */
public class DFUncheckedException extends RuntimeException {

    public DFUncheckedException() {
    }

    public DFUncheckedException(String message) {
        super(message);
    }

    public DFUncheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DFUncheckedException(Throwable cause) {
        super(cause);
    }

    public DFUncheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
