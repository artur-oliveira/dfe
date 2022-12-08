package com.softart.dfe.components.process.nf.manifestation.impl.file;

import com.softart.dfe.components.process.nf.manifestation.StoreRetManifestationNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeManifestationStorage;

final class FileStoreRetManifestationNfe extends StoreRetManifestationNfe {
    @Override
    public NfeManifestationStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
