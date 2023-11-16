package org.dfe.components.process.nf.query_gtin.impl.s3;

import org.dfe.components.process.nf.query_gtin.StoreQueryGtinNf;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfQueryGtinStorage;

final class S3StoreQueryGtinNfe extends StoreQueryGtinNf {

    public NfQueryGtinStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }

}
