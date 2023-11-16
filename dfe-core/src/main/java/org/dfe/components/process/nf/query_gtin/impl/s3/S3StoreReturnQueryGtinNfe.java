package org.dfe.components.process.nf.query_gtin.impl.s3;

import org.dfe.components.process.nf.query_gtin.StoreReturnQueryGtinNf;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfQueryGtinStorage;

final class S3StoreReturnQueryGtinNfe extends StoreReturnQueryGtinNf {

    public NfQueryGtinStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
