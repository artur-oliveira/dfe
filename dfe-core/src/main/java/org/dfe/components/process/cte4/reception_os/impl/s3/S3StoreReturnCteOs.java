package org.dfe.components.process.cte4.reception_os.impl.s3;

import org.dfe.components.process.cte4.reception_os.StoreReturnCteOs;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteReceptionOsStorage;

final class S3StoreReturnCteOs extends StoreReturnCteOs {

    @Override
    protected CteReceptionOsStorage getStorage() {
        return StorageFactory.s3().getCte4Storage();
    }
}
