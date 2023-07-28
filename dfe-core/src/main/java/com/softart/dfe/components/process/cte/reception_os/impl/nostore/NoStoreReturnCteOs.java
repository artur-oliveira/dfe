package com.softart.dfe.components.process.cte.reception_os.impl.nostore;

import com.softart.dfe.components.process.cte.reception_os.StoreReturnCteOs;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteReceptionOsStorage;

final class NoStoreReturnCteOs extends StoreReturnCteOs {

    @Override
    protected CteReceptionOsStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
