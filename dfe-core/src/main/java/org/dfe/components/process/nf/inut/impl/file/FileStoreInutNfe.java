package org.dfe.components.process.nf.inut.impl.file;

import org.dfe.components.process.nf.inut.StoreSendInutilizationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfInutStorage;

final class FileStoreInutNfe extends StoreSendInutilizationNfe {

    public NfInutStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
