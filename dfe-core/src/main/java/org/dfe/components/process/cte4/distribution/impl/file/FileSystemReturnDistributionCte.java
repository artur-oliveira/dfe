package org.dfe.components.process.cte4.distribution.impl.file;

import org.dfe.components.process.cte4.distribution.StoreReturnDistributionCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteDistributionStorage;

final class FileSystemReturnDistributionCte extends StoreReturnDistributionCte {

    @Override
    protected CteDistributionStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
