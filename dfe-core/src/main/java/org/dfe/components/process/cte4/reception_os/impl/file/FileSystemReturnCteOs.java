package org.dfe.components.process.cte4.reception_os.impl.file;

import org.dfe.components.process.cte4.reception_os.StoreReturnCteOs;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteReceptionOsStorage;

final class FileSystemReturnCteOs extends StoreReturnCteOs {

    @Override
    protected CteReceptionOsStorage getStorage() {
        return StorageFactory.fileSystem().getCte4Storage();
    }
}
