package com.softart.dfe.exceptions;

public class DfeOptionalException extends DfeUncheckedException {
    public DfeOptionalException() {
    }

    public DfeOptionalException(String message) {
        super(message);
    }

    public DfeOptionalException(String message, Throwable cause) {
        super(message, cause);
    }

    public DfeOptionalException(Throwable cause) {
        super(cause);
    }

    public DfeOptionalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
