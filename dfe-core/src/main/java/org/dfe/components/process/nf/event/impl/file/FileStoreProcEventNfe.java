package org.dfe.components.process.nf.event.impl.file;

import org.dfe.components.process.nf.event.StoreProcEventNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfEventStorage;

final class FileStoreProcEventNfe extends StoreProcEventNfe {
    @Override
    public NfEventStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
