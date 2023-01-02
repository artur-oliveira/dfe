package com.softart.dfe.exceptions.security;

/**
 * SSLContextException is a subclass of SecurityException
 */
public class SSLContextException extends SecurityException {

    public SSLContextException() {
    }

    public SSLContextException(String message) {
        super(message);
    }

    public SSLContextException(String message, Throwable cause) {
        super(message, cause);
    }

    public SSLContextException(Throwable cause) {
        super(cause);
    }

    public SSLContextException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
