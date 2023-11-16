package org.dfe.components.process.cte4.event.impl.s3;

import org.dfe.components.process.cte4.event.StoreProcEventCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteEventStorage;

final class S3StoreProcEventCte extends StoreProcEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.s3().getCte4Storage();
    }
}
