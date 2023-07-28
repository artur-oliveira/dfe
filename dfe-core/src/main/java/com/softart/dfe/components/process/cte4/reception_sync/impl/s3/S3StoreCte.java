package com.softart.dfe.components.process.cte4.reception_sync.impl.s3;

import com.softart.dfe.components.process.cte4.reception_sync.StoreCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteReceptionSyncStorage;

final class S3StoreCte extends StoreCte {

    @Override
    protected CteReceptionSyncStorage getStorage() {
        return StorageFactory.s3().getCte4Storage();
    }
}
