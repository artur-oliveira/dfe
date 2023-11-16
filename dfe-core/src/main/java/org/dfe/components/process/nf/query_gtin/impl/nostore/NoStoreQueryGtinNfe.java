package org.dfe.components.process.nf.query_gtin.impl.nostore;

import org.dfe.components.process.nf.query_gtin.StoreQueryGtinNf;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfQueryGtinStorage;

final class NoStoreQueryGtinNfe extends StoreQueryGtinNf {

    public NfQueryGtinStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }

}
