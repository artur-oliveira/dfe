package org.dfe.components.process.cte.status_service.impl.nostore;

import org.dfe.components.process.cte.status_service.StoreReturnStatusServiceCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteStatusServiceStorage;

final class NoStoreReturnStatusServiceCte extends StoreReturnStatusServiceCte {

    @Override
    protected CteStatusServiceStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
