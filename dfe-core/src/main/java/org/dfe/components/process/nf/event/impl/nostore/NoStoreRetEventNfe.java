package org.dfe.components.process.nf.event.impl.nostore;

import org.dfe.components.process.nf.event.StoreRetEventNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfEventStorage;

final class NoStoreRetEventNfe extends StoreRetEventNfe {
    @Override
    public NfEventStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
