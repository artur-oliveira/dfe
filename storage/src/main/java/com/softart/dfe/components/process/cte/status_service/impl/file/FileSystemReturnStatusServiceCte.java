package com.softart.dfe.components.process.cte.status_service.impl.file;

import com.softart.dfe.components.process.cte.status_service.StoreReturnStatusServiceCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteStatusServiceStorage;

final class FileSystemReturnStatusServiceCte extends StoreReturnStatusServiceCte {

    @Override
    protected CteStatusServiceStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
