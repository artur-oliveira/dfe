package org.dfe.components.storage.mdfe;

import org.dfe.components.storage.StorageServiceFactory;
import org.dfe.interfaces.storage.StorageService;

public final class MdfeS3Storage extends GenericMdfeStorage {

    @Override
    protected StorageService getStorageService() {
        return StorageServiceFactory.s3();
    }

}
