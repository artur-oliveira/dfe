package com.softart.dfe.exceptions.security;


/**
 * The SSLContextException class extends the SecurityException class and provides constructors for creating exceptions
 * related to SSL context.
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
