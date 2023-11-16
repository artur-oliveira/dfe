package org.dfe.components.process.nf.distribution.impl.nostore;

import org.dfe.components.process.nf.distribution.StoreRetDistributionNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeDistributionStorage;

final class NoStoreRetDistributionNfe extends StoreRetDistributionNfe {

    public NfeDistributionStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }

}
