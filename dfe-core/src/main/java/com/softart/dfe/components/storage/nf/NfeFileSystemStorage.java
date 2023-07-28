package com.softart.dfe.components.storage.nf;

import com.softart.dfe.components.storage.StorageServiceFactory;
import com.softart.dfe.interfaces.storage.StorageService;
import com.softart.dfe.interfaces.storage.nf.NfeStorage;

public final class NfeFileSystemStorage extends GenericNfeStorage implements NfeStorage {

    @Override
    protected StorageService getStorageService() {
        return StorageServiceFactory.file();
    }

}
