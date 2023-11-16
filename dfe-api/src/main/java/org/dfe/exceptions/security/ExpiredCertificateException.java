package org.dfe.exceptions.security;

/**
 * The ExpiredCertificateException class extends the SecurityException class and provides constructors for creating
 * exceptions related to expired certificates.
 */
public class ExpiredCertificateException extends SecurityException {
    public ExpiredCertificateException() {
    }

    public ExpiredCertificateException(String message) {
        super(message);
    }

    public ExpiredCertificateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpiredCertificateException(Throwable cause) {
        super(cause);
    }

    public ExpiredCertificateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
