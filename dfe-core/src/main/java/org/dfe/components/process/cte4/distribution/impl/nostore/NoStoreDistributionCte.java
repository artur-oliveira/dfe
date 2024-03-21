package org.dfe.components.process.cte4.distribution.impl.nostore;

import org.dfe.components.process.cte4.distribution.StoreDistributionCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteDistributionStorage;

final class NoStoreDistributionCte extends StoreDistributionCte {

    @Override
    protected CteDistributionStorage getStorage() {
        return StorageFactory.noStorage().getCte4Storage();
    }
}
