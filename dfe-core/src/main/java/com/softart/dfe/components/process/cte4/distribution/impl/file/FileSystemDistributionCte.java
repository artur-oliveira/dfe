package com.softart.dfe.components.process.cte4.distribution.impl.file;

import com.softart.dfe.components.process.cte4.distribution.StoreDistributionCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteDistributionStorage;

final class FileSystemDistributionCte extends StoreDistributionCte {

    @Override
    protected CteDistributionStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
