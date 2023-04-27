package com.softart.dfe.components.process.nf.query_status_service.impl.s3;

import com.softart.dfe.components.process.nf.query_status_service.StoreReturnQueryStatusServiceNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfQueryStatusServiceStorage;

final class S3StoreReturnQueryStatusServiceNfe extends StoreReturnQueryStatusServiceNfe {

    public NfQueryStatusServiceStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
