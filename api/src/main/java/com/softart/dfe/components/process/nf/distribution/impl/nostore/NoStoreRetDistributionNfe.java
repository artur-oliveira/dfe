package com.softart.dfe.components.process.nf.distribution.impl.nostore;

import com.softart.dfe.components.process.nf.distribution.StoreRetDistributionNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeDistributionStorage;

final class NoStoreRetDistributionNfe extends StoreRetDistributionNfe {

    public NfeDistributionStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }

}
