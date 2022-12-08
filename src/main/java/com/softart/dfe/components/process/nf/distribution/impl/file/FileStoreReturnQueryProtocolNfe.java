package com.softart.dfe.components.process.nf.distribution.impl.file;

import com.softart.dfe.components.process.nf.distribution.StoreRetDistributionNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeDistributionStorage;

final class FileStoreReturnQueryProtocolNfe extends StoreRetDistributionNfe {

    public NfeDistributionStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
