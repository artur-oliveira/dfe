package com.softart.dfe.components.process.cte4.event.impl.s3;

import com.softart.dfe.components.process.cte4.event.StoreEventCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteEventStorage;

final class S3StoreEventCte extends StoreEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.s3().getCte4Storage();
    }
}
