package org.dfe.components.process.cte4.distribution.impl.s3;

import org.dfe.components.process.cte4.distribution.StoreDistributionCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteDistributionStorage;

final class S3DistributionCte extends StoreDistributionCte {

    @Override
    protected CteDistributionStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
