package org.dfe.components.process.nf.distribution.impl.file;

import org.dfe.components.process.nf.distribution.StoreDistributionNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeDistributionStorage;

final class FileStoreQueryProtocolNfe extends StoreDistributionNfe {

    public NfeDistributionStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
