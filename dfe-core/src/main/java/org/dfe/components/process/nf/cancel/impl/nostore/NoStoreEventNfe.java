package org.dfe.components.process.nf.cancel.impl.nostore;

import org.dfe.components.process.nf.cancel.StoreSendCancelNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfCancelStorage;

final class NoStoreEventNfe extends StoreSendCancelNfe {
    @Override
    public NfCancelStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
