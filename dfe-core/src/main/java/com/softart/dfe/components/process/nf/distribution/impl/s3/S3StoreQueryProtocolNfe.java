package com.softart.dfe.components.process.nf.distribution.impl.s3;

import com.softart.dfe.components.process.nf.distribution.StoreDistributionNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeDistributionStorage;

final class S3StoreQueryProtocolNfe extends StoreDistributionNfe {

    public NfeDistributionStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
