package org.dfe.components.process.cte4.status_service.impl.file;

import org.dfe.components.process.cte4.status_service.StoreReturnStatusServiceCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteStatusServiceStorage;

final class FileSystemReturnStatusServiceCte extends StoreReturnStatusServiceCte {

    @Override
    protected CteStatusServiceStorage getStorage() {
        return StorageFactory.fileSystem().getCte4Storage();
    }
}
