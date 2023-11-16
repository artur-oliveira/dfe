package org.dfe.components.process.cte.reception_gtve.impl.s3;

import org.dfe.components.process.cte.reception_gtve.StoreReturnGtve;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionGtveStorage;

final class S3StoreReturnGtve extends StoreReturnGtve {

    @Override
    protected CteReceptionGtveStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
