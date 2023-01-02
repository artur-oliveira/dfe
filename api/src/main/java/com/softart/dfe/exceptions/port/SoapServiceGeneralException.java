package com.softart.dfe.exceptions.port;

import com.softart.dfe.exceptions.DFException;

/**
 * This class is a custom exception class that extends the DFException class
 */
public class SoapServiceGeneralException extends DFException {

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
