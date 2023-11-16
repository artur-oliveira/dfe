package org.dfe.components.process.cte.reception_sync.impl.file;

import org.dfe.components.process.cte.reception_sync.StoreReturnCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionSyncStorage;

final class FileSystemReturnCte extends StoreReturnCte {

    @Override
    protected CteReceptionSyncStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
