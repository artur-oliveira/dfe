package com.softart.dfe.components.process.cte.distribution.impl.s3;

import com.softart.dfe.components.process.cte.distribution.StoreReturnDistributionCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteDistributionStorage;

final class S3ReturnDistributionCte extends StoreReturnDistributionCte {

    @Override
    protected CteDistributionStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
