package com.softart.dfe.components.process.nf.manifestation.impl.file;

import com.softart.dfe.components.process.nf.manifestation.StoreProcManifestationNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeManifestationStorage;

final class FileStoreProcManifestationNfe extends StoreProcManifestationNfe {
    @Override
    public NfeManifestationStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
