package org.dfe.components.process.cte.reception_gtve.impl.file;

import org.dfe.components.process.cte.reception_gtve.StoreReturnGtve;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionGtveStorage;

final class FileSystemReturnGtve extends StoreReturnGtve {

    @Override
    protected CteReceptionGtveStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
