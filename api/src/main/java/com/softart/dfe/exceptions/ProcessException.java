package com.softart.dfe.exceptions;

/**
 * > This class is a subclass of `DFException` that is used to indicate that an error occurred while processing a request
 */
public class ProcessException extends DfeException {
    public ProcessException() {
    }

    public ProcessException(String message) {
        super(message);
    }

    public ProcessException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProcessException(Throwable cause) {
        super(cause);
    }

    public ProcessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
