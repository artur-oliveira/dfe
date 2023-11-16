package org.dfe.components.process.cte.inutilization.impl.file;

import org.dfe.components.process.cte.inutilization.StoreInutilizationCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteInutilizationStorage;

final class FileSystemInutilizationCte extends StoreInutilizationCte {

    @Override
    protected CteInutilizationStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
