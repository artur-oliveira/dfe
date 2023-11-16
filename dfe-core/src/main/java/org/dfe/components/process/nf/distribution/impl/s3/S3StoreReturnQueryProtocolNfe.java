package org.dfe.components.process.nf.distribution.impl.s3;

import org.dfe.components.process.nf.distribution.StoreRetDistributionNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeDistributionStorage;

final class S3StoreReturnQueryProtocolNfe extends StoreRetDistributionNfe {

    public NfeDistributionStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
