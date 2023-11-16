package org.dfe.components.process.cte4.status_service.impl.s3;

import org.dfe.components.process.cte4.status_service.StoreReturnStatusServiceCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteStatusServiceStorage;

final class S3StoreReturnStatusServiceCte extends StoreReturnStatusServiceCte {

    @Override
    protected CteStatusServiceStorage getStorage() {
        return StorageFactory.s3().getCte4Storage();
    }
}
