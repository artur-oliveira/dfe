package org.dfe.exceptions.internal;

import org.dfe.exceptions.DfeUncheckedException;

public class AccessKeyParserException extends DfeUncheckedException {
    public AccessKeyParserException() {
    }

    public AccessKeyParserException(String message) {
        super(message);
    }

    public AccessKeyParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessKeyParserException(Throwable cause) {
        super(cause);
    }

    public AccessKeyParserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
