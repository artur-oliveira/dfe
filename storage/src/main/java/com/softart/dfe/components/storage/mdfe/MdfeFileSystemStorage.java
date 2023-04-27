package com.softart.dfe.components.storage.mdfe;

import com.softart.dfe.components.storage.StorageServiceFactory;
import com.softart.dfe.interfaces.storage.StorageService;

public class MdfeFileSystemStorage extends GenericMdfeStorage {

    @Override
    protected StorageService getStorageService() {
        return StorageServiceFactory.file();
    }
}
