package org.dfe.components.process.cte.event.impl.s3;

import org.dfe.components.process.cte.event.StoreEventCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteEventStorage;

final class S3StoreEventCte extends StoreEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
