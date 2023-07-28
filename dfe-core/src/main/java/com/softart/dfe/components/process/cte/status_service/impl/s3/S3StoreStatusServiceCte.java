package com.softart.dfe.components.process.cte.status_service.impl.s3;

import com.softart.dfe.components.process.cte.status_service.StoreStatusServiceCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteStatusServiceStorage;

final class S3StoreStatusServiceCte extends StoreStatusServiceCte {

    @Override
    protected CteStatusServiceStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
