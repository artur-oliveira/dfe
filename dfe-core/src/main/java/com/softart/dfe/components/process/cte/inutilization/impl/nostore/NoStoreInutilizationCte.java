package com.softart.dfe.components.process.cte.inutilization.impl.nostore;

import com.softart.dfe.components.process.cte.inutilization.StoreInutilizationCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteInutilizationStorage;

final class NoStoreInutilizationCte extends StoreInutilizationCte {

    @Override
    protected CteInutilizationStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
