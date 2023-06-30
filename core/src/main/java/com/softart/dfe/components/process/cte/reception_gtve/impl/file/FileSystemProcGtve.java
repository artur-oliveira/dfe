package com.softart.dfe.components.process.cte.reception_gtve.impl.file;

import com.softart.dfe.components.process.cte.reception_gtve.StoreProcGtve;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteReceptionGtveStorage;

final class FileSystemProcGtve extends StoreProcGtve {

    @Override
    protected CteReceptionGtveStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
