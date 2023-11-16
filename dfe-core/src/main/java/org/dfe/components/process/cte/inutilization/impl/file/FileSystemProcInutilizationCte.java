package org.dfe.components.process.cte.inutilization.impl.file;

import org.dfe.components.process.cte.inutilization.StoreProcInutilizationCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteInutilizationStorage;

final class FileSystemProcInutilizationCte extends StoreProcInutilizationCte {

    @Override
    protected CteInutilizationStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
