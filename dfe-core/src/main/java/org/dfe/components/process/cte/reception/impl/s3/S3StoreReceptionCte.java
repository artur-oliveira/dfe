package org.dfe.components.process.cte.reception.impl.s3;

import org.dfe.components.process.cte.reception.StoreReceptionCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionStorage;

final class S3StoreReceptionCte extends StoreReceptionCte {

    @Override
    protected CteReceptionStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
