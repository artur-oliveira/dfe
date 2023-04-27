package com.softart.dfe.components.process.nf.cancel.impl.file;

import com.softart.dfe.components.process.nf.cancel.StoreProcCancelNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfCancelStorage;

final class FileStoreProcEventNfe extends StoreProcCancelNfe {
    @Override
    public NfCancelStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
