package com.softart.dfe.components.process.cte4.reception_gtve.impl.s3;

import com.softart.dfe.components.process.cte4.reception_gtve.StoreProcGtve;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteReceptionGtveStorage;

final class S3StoreProcGtve extends StoreProcGtve {

    @Override
    protected CteReceptionGtveStorage getStorage() {
        return StorageFactory.s3().getCte4Storage();
    }
}
