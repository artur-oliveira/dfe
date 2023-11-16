package org.dfe.components.process.cte.reception.impl.nostore;

import org.dfe.components.process.cte.reception.StoreReturnReceptionCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionStorage;

final class NoStoreReturnReceptionCte extends StoreReturnReceptionCte {

    @Override
    protected CteReceptionStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
