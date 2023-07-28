package com.softart.dfe.components.process.cte4.status_service.impl.nostore;

import com.softart.dfe.components.process.cte4.status_service.StoreReturnStatusServiceCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteStatusServiceStorage;

final class NoStoreReturnStatusServiceCte extends StoreReturnStatusServiceCte {

    @Override
    protected CteStatusServiceStorage getStorage() {
        return StorageFactory.noStorage().getCte4Storage();
    }
}
