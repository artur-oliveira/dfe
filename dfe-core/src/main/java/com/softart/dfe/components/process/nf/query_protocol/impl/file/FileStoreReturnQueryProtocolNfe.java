package com.softart.dfe.components.process.nf.query_protocol.impl.file;

import com.softart.dfe.components.process.nf.query_protocol.StoreReturnQueryProtocolNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfQueryProtocolStorage;

final class FileStoreReturnQueryProtocolNfe extends StoreReturnQueryProtocolNfe {

    public NfQueryProtocolStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
