package com.softart.dfe.exceptions.storage;

import com.softart.dfe.exceptions.ProcessException;


/**
 * The StorageException class extends the ProcessException class and provides constructors for handling exceptions related
 * to storage.
 */
public class StorageException extends ProcessException {
    public StorageException() {
    }

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }

    public StorageException(Throwable cause) {
        super(cause);
    }

    public StorageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
