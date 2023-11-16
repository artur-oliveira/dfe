package org.dfe.components.process.nf.manifestation.impl.nostore;

import org.dfe.components.process.nf.manifestation.StoreProcManifestationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeManifestationStorage;

final class NoStoreProcEventNfe extends StoreProcManifestationNfe {
    @Override
    public NfeManifestationStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
