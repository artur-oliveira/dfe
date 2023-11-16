package org.dfe.components.process.cte.reception_sync.impl.nostore;

import org.dfe.components.process.cte.reception_sync.StoreProcCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionSyncStorage;

final class NoStoreProcCte extends StoreProcCte {

    @Override
    protected CteReceptionSyncStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
