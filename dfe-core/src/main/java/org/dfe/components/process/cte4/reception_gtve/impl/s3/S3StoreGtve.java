package org.dfe.components.process.cte4.reception_gtve.impl.s3;

import org.dfe.components.process.cte4.reception_gtve.StoreGtve;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteReceptionGtveStorage;

final class S3StoreGtve extends StoreGtve {

    @Override
    protected CteReceptionGtveStorage getStorage() {
        return StorageFactory.s3().getCte4Storage();
    }
}
