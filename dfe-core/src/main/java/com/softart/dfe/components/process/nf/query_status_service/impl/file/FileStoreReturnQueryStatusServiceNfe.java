package com.softart.dfe.components.process.nf.query_status_service.impl.file;

import com.softart.dfe.components.process.nf.query_status_service.StoreReturnQueryStatusServiceNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfQueryStatusServiceStorage;

final class FileStoreReturnQueryStatusServiceNfe extends StoreReturnQueryStatusServiceNfe {

    public NfQueryStatusServiceStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
