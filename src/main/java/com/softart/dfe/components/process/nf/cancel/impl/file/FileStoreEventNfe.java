package com.softart.dfe.components.process.nf.cancel.impl.file;

import com.softart.dfe.components.process.nf.cancel.StoreSendCancelNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfCancelStorage;

final class FileStoreEventNfe extends StoreSendCancelNfe {
    @Override
    public NfCancelStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
