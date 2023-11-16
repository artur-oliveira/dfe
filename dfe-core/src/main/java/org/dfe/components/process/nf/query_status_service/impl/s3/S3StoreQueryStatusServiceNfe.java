package org.dfe.components.process.nf.query_status_service.impl.s3;

import org.dfe.components.process.nf.query_status_service.StoreQueryStatusServiceNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfQueryStatusServiceStorage;

final class S3StoreQueryStatusServiceNfe extends StoreQueryStatusServiceNfe {

    public NfQueryStatusServiceStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
