package org.dfe.components.process.nf.query_status_service.impl.file;

import org.dfe.components.process.nf.query_status_service.StoreQueryStatusServiceNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfQueryStatusServiceStorage;

final class FileStoreQueryStatusServiceNfe extends StoreQueryStatusServiceNfe {

    public NfQueryStatusServiceStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
