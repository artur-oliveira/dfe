package org.dfe.components.process.cte.distribution.impl.s3;

import org.dfe.components.process.cte.distribution.StoreReturnDistributionCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteDistributionStorage;

final class S3ReturnDistributionCte extends StoreReturnDistributionCte {

    @Override
    protected CteDistributionStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
