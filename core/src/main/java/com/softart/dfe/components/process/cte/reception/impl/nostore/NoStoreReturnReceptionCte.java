package com.softart.dfe.components.process.cte.reception.impl.nostore;

import com.softart.dfe.components.process.cte.reception.StoreReturnReceptionCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteReceptionStorage;

final class NoStoreReturnReceptionCte extends StoreReturnReceptionCte {

    @Override
    protected CteReceptionStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
