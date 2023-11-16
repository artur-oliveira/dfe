package org.dfe.components.process.nf.query_gtin.impl.nostore;

import org.dfe.components.process.nf.query_gtin.StoreReturnQueryGtinNf;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfQueryGtinStorage;

final class NoStoreReturnQueryGtinNfe extends StoreReturnQueryGtinNf {

    public NfQueryGtinStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
