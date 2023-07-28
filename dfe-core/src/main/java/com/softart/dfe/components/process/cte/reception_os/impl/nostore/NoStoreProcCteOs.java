package com.softart.dfe.components.process.cte.reception_os.impl.nostore;

import com.softart.dfe.components.process.cte.reception_os.StoreProcCteOs;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteReceptionOsStorage;

final class NoStoreProcCteOs extends StoreProcCteOs {

    @Override
    protected CteReceptionOsStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
