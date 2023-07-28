package com.softart.dfe.components.process.cte.reception.impl.file;

import com.softart.dfe.components.process.cte.reception.StoreReceptionCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteReceptionStorage;

final class FileSystemReceptionCte extends StoreReceptionCte {

    @Override
    protected CteReceptionStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
