package org.dfe.components.process.nf.distribution.impl.s3;

import org.dfe.components.process.nf.distribution.StoreDistributionNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeDistributionStorage;

final class S3StoreQueryProtocolNfe extends StoreDistributionNfe {

    public NfeDistributionStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
