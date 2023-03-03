package com.softart.dfe.components.process.cte.distribution.impl.nostore;

import com.softart.dfe.components.process.cte.distribution.StoreReturnDistributionCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteDistributionStorage;

final class NoStoreReturnDistributionCte extends StoreReturnDistributionCte {

    @Override
    protected CteDistributionStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
