package com.softart.dfe.components.process.nf.query_gtin.impl.s3;

import com.softart.dfe.components.process.nf.query_gtin.StoreQueryGtinNf;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfQueryGtinStorage;

final class S3StoreQueryGtinNfe extends StoreQueryGtinNf {

    public NfQueryGtinStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }

}
