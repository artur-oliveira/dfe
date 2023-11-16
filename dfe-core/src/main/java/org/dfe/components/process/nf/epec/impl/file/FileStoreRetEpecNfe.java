package org.dfe.components.process.nf.epec.impl.file;

import org.dfe.components.process.nf.epec.StoreRetEpecNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeEpecStorage;

final class FileStoreRetEpecNfe extends StoreRetEpecNfe {
    @Override
    public NfeEpecStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
