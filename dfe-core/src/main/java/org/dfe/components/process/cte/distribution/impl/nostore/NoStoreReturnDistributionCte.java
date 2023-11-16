package org.dfe.components.process.cte.distribution.impl.nostore;

import org.dfe.components.process.cte.distribution.StoreReturnDistributionCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteDistributionStorage;

final class NoStoreReturnDistributionCte extends StoreReturnDistributionCte {

    @Override
    protected CteDistributionStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
