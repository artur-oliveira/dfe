package org.dfe.components.process.nf.manifestation.impl.file;

import org.dfe.components.process.nf.manifestation.StoreSendManifestationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeManifestationStorage;

final class FileStoreSendManifestationNfe extends StoreSendManifestationNfe {
    @Override
    public NfeManifestationStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
