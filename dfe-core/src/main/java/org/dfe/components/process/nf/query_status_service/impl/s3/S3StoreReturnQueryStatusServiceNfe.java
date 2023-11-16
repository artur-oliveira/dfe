package org.dfe.components.process.nf.query_status_service.impl.s3;

import org.dfe.components.process.nf.query_status_service.StoreReturnQueryStatusServiceNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfQueryStatusServiceStorage;

final class S3StoreReturnQueryStatusServiceNfe extends StoreReturnQueryStatusServiceNfe {

    public NfQueryStatusServiceStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
