package org.dfe.components.process.cte.reception_sync.impl.file;

import org.dfe.components.process.cte.reception_sync.StoreProcCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionSyncStorage;

final class FileSystemProcCte extends StoreProcCte {

    @Override
    protected CteReceptionSyncStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
