package com.softart.dfe.components.process.cte4.status_service.impl.file;

import com.softart.dfe.components.process.cte4.status_service.StoreStatusServiceCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteStatusServiceStorage;

final class FileSystemStatusServiceCte extends StoreStatusServiceCte {

    @Override
    protected CteStatusServiceStorage getStorage() {
        return StorageFactory.fileSystem().getCte4Storage();
    }
}
