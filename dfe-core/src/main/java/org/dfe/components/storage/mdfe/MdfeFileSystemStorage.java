package org.dfe.components.storage.mdfe;

import org.dfe.components.storage.StorageServiceFactory;
import org.dfe.interfaces.storage.StorageService;

public class MdfeFileSystemStorage extends GenericMdfeStorage {

    @Override
    protected StorageService getStorageService() {
        return StorageServiceFactory.file();
    }
}
