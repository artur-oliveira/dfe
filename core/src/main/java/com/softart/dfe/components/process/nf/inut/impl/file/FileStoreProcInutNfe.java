package com.softart.dfe.components.process.nf.inut.impl.file;

import com.softart.dfe.components.process.nf.inut.StoreProcInutilizationNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfInutStorage;

final class FileStoreProcInutNfe extends StoreProcInutilizationNfe {

    public NfInutStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
