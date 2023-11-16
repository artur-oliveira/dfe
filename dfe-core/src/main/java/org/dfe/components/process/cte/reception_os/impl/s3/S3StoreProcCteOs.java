package org.dfe.components.process.cte.reception_os.impl.s3;

import org.dfe.components.process.cte.reception_os.StoreProcCteOs;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionOsStorage;

final class S3StoreProcCteOs extends StoreProcCteOs {

    @Override
    protected CteReceptionOsStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
