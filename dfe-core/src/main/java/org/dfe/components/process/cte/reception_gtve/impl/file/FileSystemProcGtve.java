package org.dfe.components.process.cte.reception_gtve.impl.file;

import org.dfe.components.process.cte.reception_gtve.StoreProcGtve;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionGtveStorage;

final class FileSystemProcGtve extends StoreProcGtve {

    @Override
    protected CteReceptionGtveStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
