package com.softart.dfe.components.process.cte.reception.impl.file;

import com.softart.dfe.components.process.cte.reception.StoreReturnReceptionCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteReceptionStorage;

final class FileSystemReturnReceptionCte extends StoreReturnReceptionCte {

    @Override
    protected CteReceptionStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
