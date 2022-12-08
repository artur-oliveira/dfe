package com.softart.dfe.components.process.cte.inutilization.impl.nostore;

import com.softart.dfe.components.process.cte.inutilization.StoreReturnInutilizationCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteInutilizationStorage;

final class NoStoreReturnInutilizationCte extends StoreReturnInutilizationCte {

    @Override
    protected CteInutilizationStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
