package org.dfe.components.process.nf.query_status_service.impl.file;

import org.dfe.components.process.nf.query_status_service.StoreReturnQueryStatusServiceNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfQueryStatusServiceStorage;

final class FileStoreReturnQueryStatusServiceNfe extends StoreReturnQueryStatusServiceNfe {

    public NfQueryStatusServiceStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
