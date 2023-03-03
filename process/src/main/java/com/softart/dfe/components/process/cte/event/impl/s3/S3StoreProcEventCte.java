package com.softart.dfe.components.process.cte.event.impl.s3;

import com.softart.dfe.components.process.cte.event.StoreProcEventCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteEventStorage;

final class S3StoreProcEventCte extends StoreProcEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
