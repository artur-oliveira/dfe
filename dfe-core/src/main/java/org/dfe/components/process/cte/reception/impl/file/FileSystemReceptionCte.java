package org.dfe.components.process.cte.reception.impl.file;

import org.dfe.components.process.cte.reception.StoreReceptionCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionStorage;

final class FileSystemReceptionCte extends StoreReceptionCte {

    @Override
    protected CteReceptionStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
