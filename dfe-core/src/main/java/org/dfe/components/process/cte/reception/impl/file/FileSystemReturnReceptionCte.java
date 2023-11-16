package org.dfe.components.process.cte.reception.impl.file;

import org.dfe.components.process.cte.reception.StoreReturnReceptionCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionStorage;

final class FileSystemReturnReceptionCte extends StoreReturnReceptionCte {

    @Override
    protected CteReceptionStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
