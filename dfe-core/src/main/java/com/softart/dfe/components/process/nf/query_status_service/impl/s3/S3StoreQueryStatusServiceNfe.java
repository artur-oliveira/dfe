package com.softart.dfe.components.process.nf.query_status_service.impl.s3;

import com.softart.dfe.components.process.nf.query_status_service.StoreQueryStatusServiceNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfQueryStatusServiceStorage;

final class S3StoreQueryStatusServiceNfe extends StoreQueryStatusServiceNfe {

    public NfQueryStatusServiceStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
