package org.dfe.exceptions.security;


/**
 * The class XMLSignException extends SecurityException and provides constructors for creating exceptions related to XML
 * signing.
 */
public class XMLSignException extends SecurityException {
    public XMLSignException() {
    }

    public XMLSignException(String message) {
        super(message);
    }

    public XMLSignException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLSignException(Throwable cause) {
        super(cause);
    }

    public XMLSignException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
