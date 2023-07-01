package com.softart.dfe.components.process.cte4.event.impl.s3;

import com.softart.dfe.components.process.cte4.event.StoreReturnEventCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteEventStorage;

final class S3StoreReturnEventCte extends StoreReturnEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.s3().getCte4Storage();
    }
}
