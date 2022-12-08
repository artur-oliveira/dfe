package com.softart.dfe.components.process.nf.epec.impl.nostore;

import com.softart.dfe.components.process.nf.epec.StoreSendEpecNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeEpecStorage;

final class NoStoreSendEpecNfe extends StoreSendEpecNfe {
    @Override
    public NfeEpecStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
