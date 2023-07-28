package com.softart.dfe.components.process.nf.query_status_service.impl.file;

import com.softart.dfe.components.process.nf.query_status_service.StoreQueryStatusServiceNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfQueryStatusServiceStorage;

final class FileStoreQueryStatusServiceNfe extends StoreQueryStatusServiceNfe {

    public NfQueryStatusServiceStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
