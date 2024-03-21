package org.dfe.components.process.cte4.distribution.impl.file;

import org.dfe.components.process.cte4.distribution.StoreDistributionCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteDistributionStorage;

final class FileSystemDistributionCte extends StoreDistributionCte {

    @Override
    protected CteDistributionStorage getStorage() {
        return StorageFactory.fileSystem().getCte4Storage();
    }
}
