package com.softart.dfe.components.process.nf.manifestation.impl.s3;

import com.softart.dfe.components.process.nf.manifestation.StoreProcManifestationNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeManifestationStorage;

final class S3StoreProcManifestationNfe extends StoreProcManifestationNfe {
    @Override
    public NfeManifestationStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
