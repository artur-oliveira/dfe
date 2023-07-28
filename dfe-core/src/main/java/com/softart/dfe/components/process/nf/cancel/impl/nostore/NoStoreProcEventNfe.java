package com.softart.dfe.components.process.nf.cancel.impl.nostore;

import com.softart.dfe.components.process.nf.cancel.StoreProcCancelNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfCancelStorage;

final class NoStoreProcEventNfe extends StoreProcCancelNfe {
    @Override
    public NfCancelStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
