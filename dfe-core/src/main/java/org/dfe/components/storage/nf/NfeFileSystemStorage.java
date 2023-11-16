package org.dfe.components.storage.nf;

import org.dfe.components.storage.StorageServiceFactory;
import org.dfe.interfaces.storage.StorageService;
import org.dfe.interfaces.storage.nf.NfeStorage;

public final class NfeFileSystemStorage extends GenericNfeStorage implements NfeStorage {

    @Override
    protected StorageService getStorageService() {
        return StorageServiceFactory.file();
    }

}
