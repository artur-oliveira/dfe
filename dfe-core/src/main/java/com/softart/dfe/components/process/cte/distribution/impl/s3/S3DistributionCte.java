package com.softart.dfe.components.process.cte.distribution.impl.s3;

import com.softart.dfe.components.process.cte.distribution.StoreDistributionCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteDistributionStorage;

final class S3DistributionCte extends StoreDistributionCte {

    @Override
    protected CteDistributionStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
