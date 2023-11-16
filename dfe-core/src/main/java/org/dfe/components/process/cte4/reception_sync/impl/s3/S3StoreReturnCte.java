package org.dfe.components.process.cte4.reception_sync.impl.s3;

import org.dfe.components.process.cte4.reception_sync.StoreReturnCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteReceptionSyncStorage;

final class S3StoreReturnCte extends StoreReturnCte {

    @Override
    protected CteReceptionSyncStorage getStorage() {
        return StorageFactory.s3().getCte4Storage();
    }
}
