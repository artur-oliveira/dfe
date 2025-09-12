package org.dfe.exceptions;


/**
 * The class ProcessException extends the DfeException class and provides constructors for creating exceptions with
 * different parameters.
 */
public class CircuitBreakerException extends DfeException {
    public CircuitBreakerException() {
    }

    public CircuitBreakerException(String message) {
        super(message);
    }

    public CircuitBreakerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CircuitBreakerException(Throwable cause) {
        super(cause);
    }

    public CircuitBreakerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
