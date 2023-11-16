package org.dfe.components.process.nf.cancel.impl.nostore;

import org.dfe.components.process.nf.cancel.StoreProcCancelNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfCancelStorage;

final class NoStoreProcEventNfe extends StoreProcCancelNfe {
    @Override
    public NfCancelStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
