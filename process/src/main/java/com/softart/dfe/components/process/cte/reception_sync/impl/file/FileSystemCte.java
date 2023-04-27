package com.softart.dfe.components.process.cte.reception_sync.impl.file;

import com.softart.dfe.components.process.cte.reception_sync.StoreCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteReceptionSyncStorage;

final class FileSystemCte extends StoreCte {

    @Override
    protected CteReceptionSyncStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
