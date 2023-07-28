package com.softart.dfe.components.process.cte4.status_service.impl.nostore;

import com.softart.dfe.components.process.cte4.status_service.StoreStatusServiceCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteStatusServiceStorage;

final class NoStoreStatusServiceCte extends StoreStatusServiceCte {

    @Override
    protected CteStatusServiceStorage getStorage() {
        return StorageFactory.noStorage().getCte4Storage();
    }
}
