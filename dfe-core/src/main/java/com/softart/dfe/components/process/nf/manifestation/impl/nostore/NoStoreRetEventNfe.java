package com.softart.dfe.components.process.nf.manifestation.impl.nostore;

import com.softart.dfe.components.process.nf.manifestation.StoreRetManifestationNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeManifestationStorage;

final class NoStoreRetEventNfe extends StoreRetManifestationNfe {
    @Override
    public NfeManifestationStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
