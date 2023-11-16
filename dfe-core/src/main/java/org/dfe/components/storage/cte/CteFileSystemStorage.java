package org.dfe.components.storage.cte;

import org.dfe.components.storage.StorageServiceFactory;
import org.dfe.interfaces.storage.StorageService;

public final class CteFileSystemStorage extends GenericCteStorage {

    @Override
    protected StorageService getStorageService() {
        return StorageServiceFactory.file();
    }
}
