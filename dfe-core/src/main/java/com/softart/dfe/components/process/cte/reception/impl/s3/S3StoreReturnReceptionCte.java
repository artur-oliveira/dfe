package com.softart.dfe.components.process.cte.reception.impl.s3;

import com.softart.dfe.components.process.cte.reception.StoreReturnReceptionCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteReceptionStorage;

final class S3StoreReturnReceptionCte extends StoreReturnReceptionCte {

    @Override
    protected CteReceptionStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
