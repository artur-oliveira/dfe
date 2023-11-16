package org.dfe.components.process.cte.event.impl.s3;

import org.dfe.components.process.cte.event.StoreReturnEventCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteEventStorage;

final class S3StoreReturnEventCte extends StoreReturnEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
