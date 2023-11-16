package org.dfe.components.process.nf.inut.impl.file;

import org.dfe.components.process.nf.inut.StoreRetInutilizationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfInutStorage;

final class FileStoreRetInutNfe extends StoreRetInutilizationNfe {

    public NfInutStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
