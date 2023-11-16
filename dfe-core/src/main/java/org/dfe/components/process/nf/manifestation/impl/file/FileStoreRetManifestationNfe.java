package org.dfe.components.process.nf.manifestation.impl.file;

import org.dfe.components.process.nf.manifestation.StoreRetManifestationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeManifestationStorage;

final class FileStoreRetManifestationNfe extends StoreRetManifestationNfe {
    @Override
    public NfeManifestationStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
