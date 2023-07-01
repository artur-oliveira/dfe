package com.softart.dfe.components.process.cte4.reception_os.impl.file;

import com.softart.dfe.components.process.cte4.reception_os.StoreReturnCteOs;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteReceptionOsStorage;

final class FileSystemReturnCteOs extends StoreReturnCteOs {

    @Override
    protected CteReceptionOsStorage getStorage() {
        return StorageFactory.fileSystem().getCte4Storage();
    }
}
