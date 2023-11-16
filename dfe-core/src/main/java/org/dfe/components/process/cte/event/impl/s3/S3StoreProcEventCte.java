package org.dfe.components.process.cte.event.impl.s3;

import org.dfe.components.process.cte.event.StoreProcEventCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteEventStorage;

final class S3StoreProcEventCte extends StoreProcEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
