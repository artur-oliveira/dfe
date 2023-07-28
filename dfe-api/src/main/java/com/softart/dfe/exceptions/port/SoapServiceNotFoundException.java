package com.softart.dfe.exceptions.port;


/**
 * This exception is thrown when a SOAP service is not found
 */
public class SoapServiceNotFoundException extends SoapServiceGeneralException {

    public SoapServiceNotFoundException() {
    }

    public SoapServiceNotFoundException(String message) {
        super(message);
    }

    public SoapServiceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SoapServiceNotFoundException(Throwable cause) {
        super(cause);
    }

    public SoapServiceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
