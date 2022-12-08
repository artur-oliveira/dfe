package com.softart.dfe.components.process.nf.query_gtin.impl.nostore;

import com.softart.dfe.components.process.nf.query_gtin.StoreReturnQueryGtinNf;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfQueryGtinStorage;

final class NoStoreReturnQueryGtinNfe extends StoreReturnQueryGtinNf {

    public NfQueryGtinStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
