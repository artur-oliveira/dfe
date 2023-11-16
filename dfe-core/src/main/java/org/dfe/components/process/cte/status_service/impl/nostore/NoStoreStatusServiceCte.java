package org.dfe.components.process.cte.status_service.impl.nostore;

import org.dfe.components.process.cte.status_service.StoreStatusServiceCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteStatusServiceStorage;

final class NoStoreStatusServiceCte extends StoreStatusServiceCte {

    @Override
    protected CteStatusServiceStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
