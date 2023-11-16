package org.dfe.exceptions;

public class FederalDocumentUtilsException extends DfeUncheckedException {

    public FederalDocumentUtilsException() {
    }

    public FederalDocumentUtilsException(String message) {
        super(message);
    }

    public FederalDocumentUtilsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FederalDocumentUtilsException(Throwable cause) {
        super(cause);
    }

    public FederalDocumentUtilsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
