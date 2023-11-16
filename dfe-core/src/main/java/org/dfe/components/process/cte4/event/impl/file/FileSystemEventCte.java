package org.dfe.components.process.cte4.event.impl.file;

import org.dfe.components.process.cte4.event.StoreEventCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteEventStorage;

final class FileSystemEventCte extends StoreEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.fileSystem().getCte4Storage();
    }
}
