package org.dfe.components.process.cte.reception_gtve.impl.s3;

import org.dfe.components.process.cte.reception_gtve.StoreGtve;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionGtveStorage;

final class S3StoreGtve extends StoreGtve {

    @Override
    protected CteReceptionGtveStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
