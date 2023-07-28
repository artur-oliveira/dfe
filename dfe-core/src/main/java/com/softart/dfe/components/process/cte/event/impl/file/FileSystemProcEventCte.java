package com.softart.dfe.components.process.cte.event.impl.file;

import com.softart.dfe.components.process.cte.event.StoreProcEventCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteEventStorage;

final class FileSystemProcEventCte extends StoreProcEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
