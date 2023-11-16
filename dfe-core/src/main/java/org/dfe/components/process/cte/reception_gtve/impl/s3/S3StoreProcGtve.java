package org.dfe.components.process.cte.reception_gtve.impl.s3;

import org.dfe.components.process.cte.reception_gtve.StoreProcGtve;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionGtveStorage;

final class S3StoreProcGtve extends StoreProcGtve {

    @Override
    protected CteReceptionGtveStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
