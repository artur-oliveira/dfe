package com.softart.dfe.components.process.cte.inutilization.impl.file;

import com.softart.dfe.components.process.cte.inutilization.StoreReturnInutilizationCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteInutilizationStorage;

final class FileSystemReturnInutilizationCte extends StoreReturnInutilizationCte {

    @Override
    protected CteInutilizationStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
