package org.dfe.components.process.cte4.event.impl.nostore;

import org.dfe.components.process.cte4.event.StoreProcEventCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteEventStorage;

final class NoStoreProcEventCte extends StoreProcEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.noStorage().getCte4Storage();
    }
}
