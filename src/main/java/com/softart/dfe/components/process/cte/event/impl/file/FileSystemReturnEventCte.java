package com.softart.dfe.components.process.cte.event.impl.file;

import com.softart.dfe.components.process.cte.event.StoreReturnEventCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteEventStorage;

final class FileSystemReturnEventCte extends StoreReturnEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
