package com.softart.dfe.exceptions.security;


/**
 * The CertificateException class extends the SecurityException class and provides constructors for creating exceptions
 * related to certificate errors.
 */
public class CertificateException extends SecurityException {
    public CertificateException() {
    }

    public CertificateException(String message) {
        super(message);
    }

    public CertificateException(String message, Throwable cause) {
        super(message, cause);
    }

    public CertificateException(Throwable cause) {
        super(cause);
    }

    public CertificateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
