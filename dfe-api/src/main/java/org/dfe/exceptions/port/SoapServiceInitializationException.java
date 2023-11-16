package org.dfe.exceptions.port;


/**
 * This is a Java class for a SoapServiceInitializationException that extends a SoapServiceGeneralException and provides
 * constructors for different types of exceptions.
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
