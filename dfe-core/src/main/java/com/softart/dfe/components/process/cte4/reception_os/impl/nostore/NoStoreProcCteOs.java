package com.softart.dfe.components.process.cte4.reception_os.impl.nostore;

import com.softart.dfe.components.process.cte4.reception_os.StoreProcCteOs;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteReceptionOsStorage;

final class NoStoreProcCteOs extends StoreProcCteOs {

    @Override
    protected CteReceptionOsStorage getStorage() {
        return StorageFactory.noStorage().getCte4Storage();
    }
}
