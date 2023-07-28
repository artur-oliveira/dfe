package com.softart.dfe.components.process.nf.manifestation.impl.s3;

import com.softart.dfe.components.process.nf.manifestation.StoreSendManifestationNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeManifestationStorage;

final class S3StoreSendManifestationNfe extends StoreSendManifestationNfe {
    @Override
    public NfeManifestationStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
