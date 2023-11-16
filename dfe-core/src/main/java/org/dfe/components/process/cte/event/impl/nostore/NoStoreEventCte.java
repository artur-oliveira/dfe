package org.dfe.components.process.cte.event.impl.nostore;

import org.dfe.components.process.cte.event.StoreEventCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteEventStorage;

final class NoStoreEventCte extends StoreEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
