package org.dfe.components.storage.nf;

import org.dfe.components.storage.StorageServiceFactory;
import org.dfe.interfaces.storage.StorageService;

public final class NfceFileSystemStorage extends GenericNfceStorage {

    @Override
    protected StorageService getStorageService() {
        return StorageServiceFactory.file();
    }
}
