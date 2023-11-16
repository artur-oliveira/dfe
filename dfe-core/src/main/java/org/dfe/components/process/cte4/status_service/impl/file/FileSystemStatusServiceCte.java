package org.dfe.components.process.cte4.status_service.impl.file;

import org.dfe.components.process.cte4.status_service.StoreStatusServiceCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteStatusServiceStorage;

final class FileSystemStatusServiceCte extends StoreStatusServiceCte {

    @Override
    protected CteStatusServiceStorage getStorage() {
        return StorageFactory.fileSystem().getCte4Storage();
    }
}
