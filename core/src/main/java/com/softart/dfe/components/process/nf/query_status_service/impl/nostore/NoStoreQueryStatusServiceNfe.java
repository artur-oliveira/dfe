package com.softart.dfe.components.process.nf.query_status_service.impl.nostore;

import com.softart.dfe.components.process.nf.query_status_service.StoreQueryStatusServiceNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfQueryStatusServiceStorage;

final class NoStoreQueryStatusServiceNfe extends StoreQueryStatusServiceNfe {

    public NfQueryStatusServiceStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }

}
