package com.softart.dfe.components.process.cte4.status_service.impl.s3;

import com.softart.dfe.components.process.cte4.status_service.StoreStatusServiceCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteStatusServiceStorage;

final class S3StoreStatusServiceCte extends StoreStatusServiceCte {

    @Override
    protected CteStatusServiceStorage getStorage() {
        return StorageFactory.s3().getCte4Storage();
    }
}
