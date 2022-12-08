package com.softart.dfe.components.process.nf.epec.impl.file;

import com.softart.dfe.components.process.nf.epec.StoreRetEpecNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeEpecStorage;

final class FileStoreRetEpecNfe extends StoreRetEpecNfe {
    @Override
    public NfeEpecStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
