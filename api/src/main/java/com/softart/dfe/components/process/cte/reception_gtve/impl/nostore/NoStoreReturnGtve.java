package com.softart.dfe.components.process.cte.reception_gtve.impl.nostore;

import com.softart.dfe.components.process.cte.reception_gtve.StoreReturnGtve;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteReceptionGtveStorage;

final class NoStoreReturnGtve extends StoreReturnGtve {

    @Override
    protected CteReceptionGtveStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
