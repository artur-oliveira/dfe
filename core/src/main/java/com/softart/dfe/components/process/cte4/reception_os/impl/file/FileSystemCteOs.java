package com.softart.dfe.components.process.cte4.reception_os.impl.file;

import com.softart.dfe.components.process.cte4.reception_os.StoreCteOs;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteReceptionOsStorage;

final class FileSystemCteOs extends StoreCteOs {

    @Override
    protected CteReceptionOsStorage getStorage() {
        return StorageFactory.fileSystem().getCte4Storage();
    }
}