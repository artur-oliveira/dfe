package com.softart.dfe.components.process.cte.reception_sync.impl.s3;

import com.softart.dfe.components.process.cte.reception_sync.StoreProcCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteReceptionSyncStorage;

final class S3StoreProcCte extends StoreProcCte {

    @Override
    protected CteReceptionSyncStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
