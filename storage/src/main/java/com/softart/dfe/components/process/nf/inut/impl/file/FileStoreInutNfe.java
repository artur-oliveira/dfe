package com.softart.dfe.components.process.nf.inut.impl.file;

import com.softart.dfe.components.process.nf.inut.StoreSendInutilizationNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfInutStorage;

final class FileStoreInutNfe extends StoreSendInutilizationNfe {

    public NfInutStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
