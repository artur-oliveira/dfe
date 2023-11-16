package org.dfe.components.storage.nf;

import org.dfe.components.storage.StorageServiceFactory;
import org.dfe.interfaces.storage.StorageService;

public final class NfeS3Storage extends GenericNfeStorage {

    @Override
    protected StorageService getStorageService() {
        return StorageServiceFactory.s3();
    }

}
