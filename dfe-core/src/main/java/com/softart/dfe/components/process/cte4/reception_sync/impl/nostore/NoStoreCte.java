package com.softart.dfe.components.process.cte4.reception_sync.impl.nostore;

import com.softart.dfe.components.process.cte4.reception_sync.StoreCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteReceptionSyncStorage;

final class NoStoreCte extends StoreCte {

    @Override
    protected CteReceptionSyncStorage getStorage() {
        return StorageFactory.noStorage().getCte4Storage();
    }
}
