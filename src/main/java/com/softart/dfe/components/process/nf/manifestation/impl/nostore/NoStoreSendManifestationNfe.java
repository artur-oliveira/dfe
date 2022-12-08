package com.softart.dfe.components.process.nf.manifestation.impl.nostore;

import com.softart.dfe.components.process.nf.manifestation.StoreSendManifestationNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeManifestationStorage;

final class NoStoreSendManifestationNfe extends StoreSendManifestationNfe {
    @Override
    public NfeManifestationStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
