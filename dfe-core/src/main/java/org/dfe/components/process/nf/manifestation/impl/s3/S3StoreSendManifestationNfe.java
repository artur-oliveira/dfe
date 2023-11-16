package org.dfe.components.process.nf.manifestation.impl.s3;

import org.dfe.components.process.nf.manifestation.StoreSendManifestationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeManifestationStorage;

final class S3StoreSendManifestationNfe extends StoreSendManifestationNfe {
    @Override
    public NfeManifestationStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
