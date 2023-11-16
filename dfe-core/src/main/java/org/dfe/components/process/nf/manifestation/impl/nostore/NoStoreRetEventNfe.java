package org.dfe.components.process.nf.manifestation.impl.nostore;

import org.dfe.components.process.nf.manifestation.StoreRetManifestationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeManifestationStorage;

final class NoStoreRetEventNfe extends StoreRetManifestationNfe {
    @Override
    public NfeManifestationStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
