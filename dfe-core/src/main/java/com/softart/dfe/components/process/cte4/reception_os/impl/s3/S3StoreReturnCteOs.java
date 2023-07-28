package com.softart.dfe.components.process.cte4.reception_os.impl.s3;

import com.softart.dfe.components.process.cte4.reception_os.StoreReturnCteOs;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteReceptionOsStorage;

final class S3StoreReturnCteOs extends StoreReturnCteOs {

    @Override
    protected CteReceptionOsStorage getStorage() {
        return StorageFactory.s3().getCte4Storage();
    }
}
