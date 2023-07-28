package com.softart.dfe.components.process.cte4.reception_sync.impl.file;

import com.softart.dfe.components.process.cte4.reception_sync.StoreProcCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteReceptionSyncStorage;

final class FileSystemProcCte extends StoreProcCte {

    @Override
    protected CteReceptionSyncStorage getStorage() {
        return StorageFactory.fileSystem().getCte4Storage();
    }
}
