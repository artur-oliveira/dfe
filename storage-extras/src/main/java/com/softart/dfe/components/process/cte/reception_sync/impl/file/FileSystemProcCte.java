package com.softart.dfe.components.process.cte.reception_sync.impl.file;

import com.softart.dfe.components.process.cte.reception_sync.StoreProcCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteReceptionSyncStorage;

final class FileSystemProcCte extends StoreProcCte {

    @Override
    protected CteReceptionSyncStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
