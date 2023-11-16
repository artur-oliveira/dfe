package org.dfe.components.process.cte.inutilization.impl.s3;

import org.dfe.components.process.cte.inutilization.StoreInutilizationCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteInutilizationStorage;

final class S3StoreInutilizationCte extends StoreInutilizationCte {

    @Override
    protected CteInutilizationStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
