package com.softart.dfe.components.process.cte4.reception_os.impl.s3;

import com.softart.dfe.components.process.cte4.reception_os.StoreCteOs;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteReceptionOsStorage;

final class S3StoreCteOs extends StoreCteOs {

    @Override
    protected CteReceptionOsStorage getStorage() {
        return StorageFactory.s3().getCte4Storage();
    }
}
