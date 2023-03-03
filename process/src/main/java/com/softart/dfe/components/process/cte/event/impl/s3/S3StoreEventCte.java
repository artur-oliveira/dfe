package com.softart.dfe.components.process.cte.event.impl.s3;

import com.softart.dfe.components.process.cte.event.StoreEventCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteEventStorage;

final class S3StoreEventCte extends StoreEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
