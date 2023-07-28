package com.softart.dfe.components.storage.cte;

import com.softart.dfe.components.storage.StorageServiceFactory;
import com.softart.dfe.interfaces.storage.StorageService;

public final class CteS3Storage extends GenericCteStorage {

    @Override
    protected StorageService getStorageService() {
        return StorageServiceFactory.s3();
    }
}
