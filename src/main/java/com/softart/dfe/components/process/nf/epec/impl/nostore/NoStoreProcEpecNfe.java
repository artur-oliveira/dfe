package com.softart.dfe.components.process.nf.epec.impl.nostore;

import com.softart.dfe.components.process.nf.epec.StoreProcEpecNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeEpecStorage;

final class NoStoreProcEpecNfe extends StoreProcEpecNfe {
    @Override
    public NfeEpecStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
