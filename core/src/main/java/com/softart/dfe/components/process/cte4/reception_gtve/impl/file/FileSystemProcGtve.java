package com.softart.dfe.components.process.cte4.reception_gtve.impl.file;

import com.softart.dfe.components.process.cte4.reception_gtve.StoreProcGtve;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteReceptionGtveStorage;

final class FileSystemProcGtve extends StoreProcGtve {

    @Override
    protected CteReceptionGtveStorage getStorage() {
        return StorageFactory.fileSystem().getCte4Storage();
    }
}
