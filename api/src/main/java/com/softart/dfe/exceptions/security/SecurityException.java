package com.softart.dfe.exceptions.security;

import com.softart.dfe.exceptions.DfeException;

/**
 * SecurityException is the base class for all security related exceptions
 */
public abstract class SecurityException extends DfeException {

    public SecurityException() {
    }

    public SecurityException(String message) {
        super(message);
    }

    public SecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecurityException(Throwable cause) {
        super(cause);
    }

    public SecurityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
