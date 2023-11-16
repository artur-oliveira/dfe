package org.dfe.components.process.nf.inut.impl.file;

import org.dfe.components.process.nf.inut.StoreProcInutilizationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfInutStorage;

final class FileStoreProcInutNfe extends StoreProcInutilizationNfe {

    public NfInutStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
