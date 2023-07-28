package com.softart.dfe.exceptions.port;

import com.softart.dfe.exceptions.DfeException;


/**
 * The class `SoapServiceGeneralException` is a subclass of `DfeException` used to handle general exceptions in SOAP
 * services.
 */
public class SoapServiceGeneralException extends DfeException {

    public SoapServiceGeneralException() {
    }

    public SoapServiceGeneralException(String message) {
        super(message);
    }

    public SoapServiceGeneralException(String message, Throwable cause) {
        super(message, cause);
    }

    public SoapServiceGeneralException(Throwable cause) {
        super(cause);
    }

    public SoapServiceGeneralException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
