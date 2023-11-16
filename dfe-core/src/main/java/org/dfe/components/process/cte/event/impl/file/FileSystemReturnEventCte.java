package org.dfe.components.process.cte.event.impl.file;

import org.dfe.components.process.cte.event.StoreReturnEventCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteEventStorage;

final class FileSystemReturnEventCte extends StoreReturnEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
