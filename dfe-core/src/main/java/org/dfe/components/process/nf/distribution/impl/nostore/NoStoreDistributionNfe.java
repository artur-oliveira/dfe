package org.dfe.components.process.nf.distribution.impl.nostore;

import org.dfe.components.process.nf.distribution.StoreDistributionNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeDistributionStorage;

final class NoStoreDistributionNfe extends StoreDistributionNfe {

    public NfeDistributionStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }

}
