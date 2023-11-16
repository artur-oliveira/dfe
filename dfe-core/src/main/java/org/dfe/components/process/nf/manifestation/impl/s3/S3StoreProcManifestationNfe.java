package org.dfe.components.process.nf.manifestation.impl.s3;

import org.dfe.components.process.nf.manifestation.StoreProcManifestationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeManifestationStorage;

final class S3StoreProcManifestationNfe extends StoreProcManifestationNfe {
    @Override
    public NfeManifestationStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
