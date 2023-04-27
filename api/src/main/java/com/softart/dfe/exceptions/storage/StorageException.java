package com.softart.dfe.exceptions.storage;

import com.softart.dfe.exceptions.ProcessException;

/**
 * > This class is a subclass of ProcessException that is used to indicate that an error occurred while trying to access
 * the storage system
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
