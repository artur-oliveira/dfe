package com.softart.dfe.components.process.cte4.reception_sync.impl.s3;

import com.softart.dfe.components.process.cte4.reception_sync.StoreReturnCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteReceptionSyncStorage;

final class S3StoreReturnCte extends StoreReturnCte {

    @Override
    protected CteReceptionSyncStorage getStorage() {
        return StorageFactory.s3().getCte4Storage();
    }
}
