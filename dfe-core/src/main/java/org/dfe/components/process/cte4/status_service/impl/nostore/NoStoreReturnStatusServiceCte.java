package org.dfe.components.process.cte4.status_service.impl.nostore;

import org.dfe.components.process.cte4.status_service.StoreReturnStatusServiceCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteStatusServiceStorage;

final class NoStoreReturnStatusServiceCte extends StoreReturnStatusServiceCte {

    @Override
    protected CteStatusServiceStorage getStorage() {
        return StorageFactory.noStorage().getCte4Storage();
    }
}
