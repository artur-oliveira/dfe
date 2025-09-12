package org.dfe.components.process.nf.event.impl.file;

import org.dfe.components.process.nf.event.StoreRetEventNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfEventStorage;

final class FileStoreRetEventNfe extends StoreRetEventNfe {
    @Override
    public NfEventStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
