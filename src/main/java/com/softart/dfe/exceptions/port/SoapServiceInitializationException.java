package com.softart.dfe.exceptions.port;

/**
 * This exception is thrown when the SOAP service fails to initialize
 */
public class SoapServiceInitializationException extends SoapServiceGeneralException {

    public SoapServiceInitializationException() {
    }

    public SoapServiceInitializationException(String message) {
        super(message);
    }

    public SoapServiceInitializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SoapServiceInitializationException(Throwable cause) {
        super(cause);
    }

    public SoapServiceInitializationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
