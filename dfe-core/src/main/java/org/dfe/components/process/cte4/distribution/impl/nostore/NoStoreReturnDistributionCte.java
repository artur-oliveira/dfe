package org.dfe.components.process.cte4.distribution.impl.nostore;

import org.dfe.components.process.cte4.distribution.StoreReturnDistributionCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteDistributionStorage;

final class NoStoreReturnDistributionCte extends StoreReturnDistributionCte {

    @Override
    protected CteDistributionStorage getStorage() {
        return StorageFactory.noStorage().getCte4Storage();
    }
}
