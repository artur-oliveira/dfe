package org.dfe.components.process.nf.query_protocol.impl.file;

import org.dfe.components.process.nf.query_protocol.StoreReturnQueryProtocolNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfQueryProtocolStorage;

final class FileStoreReturnQueryProtocolNfe extends StoreReturnQueryProtocolNfe {

    public NfQueryProtocolStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
