package org.dfe.components.process.cte.status_service.impl.file;

import org.dfe.components.process.cte.status_service.StoreStatusServiceCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteStatusServiceStorage;

final class FileSystemStatusServiceCte extends StoreStatusServiceCte {

    @Override
    protected CteStatusServiceStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
