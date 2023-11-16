package org.dfe.components.process.cte.reception_os.impl.s3;

import org.dfe.components.process.cte.reception_os.StoreReturnCteOs;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionOsStorage;

final class S3StoreReturnCteOs extends StoreReturnCteOs {

    @Override
    protected CteReceptionOsStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
