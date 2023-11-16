package org.dfe.components.process.nf.epec.impl.nostore;

import org.dfe.components.process.nf.epec.StoreSendEpecNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeEpecStorage;

final class NoStoreSendEpecNfe extends StoreSendEpecNfe {
    @Override
    public NfeEpecStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
