package org.dfe.components.process.nf.query_gtin.impl.file;

import org.dfe.components.process.nf.query_gtin.StoreQueryGtinNf;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfQueryGtinStorage;

final class FileStoreQueryGtinNfe extends StoreQueryGtinNf {

    public NfQueryGtinStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
