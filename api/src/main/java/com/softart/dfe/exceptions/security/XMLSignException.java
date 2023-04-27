package com.softart.dfe.exceptions.security;

/**
 * XMLSignException is a SecurityException that is thrown when an error occurs during XML signature generation or
 * validation
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
