package org.dfe.components.process.cte4.reception_sync.impl.file;

import org.dfe.components.process.cte4.reception_sync.StoreReturnCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteReceptionSyncStorage;

final class FileSystemReturnCte extends StoreReturnCte {

    @Override
    protected CteReceptionSyncStorage getStorage() {
        return StorageFactory.fileSystem().getCte4Storage();
    }
}
