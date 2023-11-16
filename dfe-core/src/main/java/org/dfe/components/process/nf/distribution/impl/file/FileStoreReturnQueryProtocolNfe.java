package org.dfe.components.process.nf.distribution.impl.file;

import org.dfe.components.process.nf.distribution.StoreRetDistributionNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeDistributionStorage;

final class FileStoreReturnQueryProtocolNfe extends StoreRetDistributionNfe {

    public NfeDistributionStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
