package org.dfe.exceptions.internal;

import org.dfe.exceptions.DfeUncheckedException;

public class AccessKeyGeneratorException extends DfeUncheckedException {
    public AccessKeyGeneratorException() {
    }

    public AccessKeyGeneratorException(String message) {
        super(message);
    }

    public AccessKeyGeneratorException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessKeyGeneratorException(Throwable cause) {
        super(cause);
    }

    public AccessKeyGeneratorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
