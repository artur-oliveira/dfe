package com.softart.dfe.components.process.nf.distribution.impl.s3;

import com.softart.dfe.components.process.nf.distribution.StoreRetDistributionNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeDistributionStorage;

final class S3StoreReturnQueryProtocolNfe extends StoreRetDistributionNfe {

    public NfeDistributionStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
