package org.dfe.components.process.cte.reception_sync.impl.s3;

import org.dfe.components.process.cte.reception_sync.StoreReturnCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionSyncStorage;

final class S3StoreReturnCte extends StoreReturnCte {

    @Override
    protected CteReceptionSyncStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
