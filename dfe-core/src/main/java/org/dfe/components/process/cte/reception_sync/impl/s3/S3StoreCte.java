package org.dfe.components.process.cte.reception_sync.impl.s3;

import org.dfe.components.process.cte.reception_sync.StoreCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionSyncStorage;

final class S3StoreCte extends StoreCte {

    @Override
    protected CteReceptionSyncStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
