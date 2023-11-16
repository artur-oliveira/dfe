package org.dfe.components.process.cte.reception_sync.impl.file;

import org.dfe.components.process.cte.reception_sync.StoreCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionSyncStorage;

final class FileSystemCte extends StoreCte {

    @Override
    protected CteReceptionSyncStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
