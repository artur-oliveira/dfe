package org.dfe.components.process.cte.distribution.impl.file;

import org.dfe.components.process.cte.distribution.StoreDistributionCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteDistributionStorage;

final class FileSystemDistributionCte extends StoreDistributionCte {

    @Override
    protected CteDistributionStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
