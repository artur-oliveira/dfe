package org.dfe.components.process.nf.event.impl.nostore;

import org.dfe.components.process.nf.event.StoreSendEventNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfEventStorage;

final class NoStoreEventNfe extends StoreSendEventNfe {
    @Override
    public NfEventStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
