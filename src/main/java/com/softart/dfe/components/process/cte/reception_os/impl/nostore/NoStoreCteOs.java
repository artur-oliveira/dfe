package com.softart.dfe.components.process.cte.reception_os.impl.nostore;

import com.softart.dfe.components.process.cte.reception_os.StoreCteOs;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteReceptionOsStorage;

final class NoStoreCteOs extends StoreCteOs {

    @Override
    protected CteReceptionOsStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
