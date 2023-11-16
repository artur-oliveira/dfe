package org.dfe.components.process.nf.cancel.impl.nostore;

import org.dfe.components.process.nf.cancel.StoreRetCancelNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfCancelStorage;

final class NoStoreRetEventNfe extends StoreRetCancelNfe {
    @Override
    public NfCancelStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
