package org.dfe.components.process.cte.reception_gtve.impl.file;

import org.dfe.components.process.cte.reception_gtve.StoreGtve;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionGtveStorage;

final class FileSystemGtve extends StoreGtve {

    @Override
    protected CteReceptionGtveStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
