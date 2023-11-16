package org.dfe.components.process.cte4.event.impl.nostore;

import org.dfe.components.process.cte4.event.StoreReturnEventCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteEventStorage;

final class NoStoreReturnEventCte extends StoreReturnEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.noStorage().getCte4Storage();
    }
}
