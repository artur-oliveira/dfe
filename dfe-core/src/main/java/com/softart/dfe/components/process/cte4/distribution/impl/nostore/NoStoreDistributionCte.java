package com.softart.dfe.components.process.cte4.distribution.impl.nostore;

import com.softart.dfe.components.process.cte4.distribution.StoreDistributionCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteDistributionStorage;

final class NoStoreDistributionCte extends StoreDistributionCte {

    @Override
    protected CteDistributionStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
