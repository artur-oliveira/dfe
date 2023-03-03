package com.softart.dfe.components.process.cte.event.impl.s3;

import com.softart.dfe.components.process.cte.event.StoreReturnEventCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteEventStorage;

final class S3StoreReturnEventCte extends StoreReturnEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
