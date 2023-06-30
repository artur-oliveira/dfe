package com.softart.dfe.components.storage.nf;

import com.softart.dfe.components.storage.StorageServiceFactory;
import com.softart.dfe.interfaces.storage.StorageService;

public final class NfeS3Storage extends GenericNfeStorage {

    @Override
    protected StorageService getStorageService() {
        return StorageServiceFactory.s3();
    }

}
