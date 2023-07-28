package com.softart.dfe.components.process.cte4.event.impl.file;

import com.softart.dfe.components.process.cte4.event.StoreReturnEventCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteEventStorage;

final class FileSystemReturnEventCte extends StoreReturnEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.fileSystem().getCte4Storage();
    }
}
