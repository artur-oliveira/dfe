package org.dfe.components.process.cte4.reception_sync.impl.nostore;

import org.dfe.components.process.cte4.reception_sync.StoreCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteReceptionSyncStorage;

final class NoStoreCte extends StoreCte {

    @Override
    protected CteReceptionSyncStorage getStorage() {
        return StorageFactory.noStorage().getCte4Storage();
    }
}
