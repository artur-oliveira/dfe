package org.dfe.components.process.cte.reception_os.impl.file;

import org.dfe.components.process.cte.reception_os.StoreProcCteOs;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionOsStorage;

final class FileSystemProcCteOs extends StoreProcCteOs {

    @Override
    protected CteReceptionOsStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
