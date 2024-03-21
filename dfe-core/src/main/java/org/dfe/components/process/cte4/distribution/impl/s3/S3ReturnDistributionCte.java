package org.dfe.components.process.cte4.distribution.impl.s3;

import org.dfe.components.process.cte4.distribution.StoreReturnDistributionCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteDistributionStorage;

final class S3ReturnDistributionCte extends StoreReturnDistributionCte {

    @Override
    protected CteDistributionStorage getStorage() {
        return StorageFactory.s3().getCte4Storage();
    }
}
