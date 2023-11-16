package org.dfe.components.storage.common;

import org.dfe.interfaces.storage.StorageService;

import java.util.UUID;

public abstract class CommonStorage {
    /**
     * It returns a string that is a combination of the prefix, the current time, a random UUID, and the .xml extension.
     *
     * @param prefix The prefix of the file name.
     * @return A string that is a combination of the prefix, the current time, a random UUID, and the file extension.
     */
    protected String xmlNameWithTime(Object prefix) {
        return (prefix.toString().isEmpty() ? "" : prefix + "_") + System.currentTimeMillis() + "-" + UUID.randomUUID() + ".xml";
    }

    /**
     * Return a string that is a random UUID with a timestamp prepended to it.
     *
     * @return A string that is the current time in milliseconds, a dash, a random UUID, and the .xml extension.
     */
    protected String xmlNameWithTime() {
        return System.currentTimeMillis() + "-" + UUID.randomUUID() + ".xml";
    }

    /**
     * This function returns a StorageService object that can be used to access the storage service.
     *
     * @return The StorageService object.
     */
    protected abstract StorageService getStorageService();
}
