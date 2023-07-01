package com.softart.dfe.components.process.cte4.distribution.impl.file;

import com.softart.dfe.components.process.cte4.distribution.StoreReturnDistributionCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteDistributionStorage;

final class FileSystemReturnDistributionCte extends StoreReturnDistributionCte {

    @Override
    protected CteDistributionStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
