package com.softart.dfe.components.process.nf.distribution.impl.file;

import com.softart.dfe.components.process.nf.distribution.StoreDistributionNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeDistributionStorage;

final class FileStoreQueryProtocolNfe extends StoreDistributionNfe {

    public NfeDistributionStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
