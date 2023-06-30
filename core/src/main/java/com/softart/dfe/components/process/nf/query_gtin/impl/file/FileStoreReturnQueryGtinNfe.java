package com.softart.dfe.components.process.nf.query_gtin.impl.file;

import com.softart.dfe.components.process.nf.query_gtin.StoreReturnQueryGtinNf;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfQueryGtinStorage;

final class FileStoreReturnQueryGtinNfe extends StoreReturnQueryGtinNf {

    public NfQueryGtinStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
