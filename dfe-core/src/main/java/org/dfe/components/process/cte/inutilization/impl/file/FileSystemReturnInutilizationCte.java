package org.dfe.components.process.cte.inutilization.impl.file;

import org.dfe.components.process.cte.inutilization.StoreReturnInutilizationCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteInutilizationStorage;

final class FileSystemReturnInutilizationCte extends StoreReturnInutilizationCte {

    @Override
    protected CteInutilizationStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
