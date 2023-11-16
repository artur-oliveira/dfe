package org.dfe.components.process.cte.event.impl.nostore;

import org.dfe.components.process.cte.event.StoreReturnEventCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteEventStorage;

final class NoStoreReturnEventCte extends StoreReturnEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
