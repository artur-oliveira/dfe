package com.softart.dfe.components.storage.mdfe;

import com.softart.dfe.components.storage.StorageServiceFactory;
import com.softart.dfe.interfaces.storage.StorageService;

public final class MdfeS3Storage extends GenericMdfeStorage {

    @Override
    protected StorageService getStorageService() {
        return StorageServiceFactory.s3();
    }

}
