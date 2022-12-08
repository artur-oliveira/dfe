package com.softart.dfe.components.process.cte.inutilization.impl.file;

import com.softart.dfe.components.process.cte.inutilization.StoreProcInutilizationCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteInutilizationStorage;

final class FileSystemProcInutilizationCte extends StoreProcInutilizationCte {

    @Override
    protected CteInutilizationStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
