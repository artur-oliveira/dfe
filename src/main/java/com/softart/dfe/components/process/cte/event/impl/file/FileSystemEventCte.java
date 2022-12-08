package com.softart.dfe.components.process.cte.event.impl.file;

import com.softart.dfe.components.process.cte.event.StoreEventCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteEventStorage;

final class FileSystemEventCte extends StoreEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
