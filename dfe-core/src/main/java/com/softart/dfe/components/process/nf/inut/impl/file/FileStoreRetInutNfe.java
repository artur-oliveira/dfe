package com.softart.dfe.components.process.nf.inut.impl.file;

import com.softart.dfe.components.process.nf.inut.StoreRetInutilizationNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfInutStorage;

final class FileStoreRetInutNfe extends StoreRetInutilizationNfe {

    public NfInutStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
