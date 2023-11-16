package org.dfe.components.process.cte.inutilization.impl.s3;

import org.dfe.components.process.cte.inutilization.StoreReturnInutilizationCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteInutilizationStorage;

final class S3StoreReturnInutilizationCte extends StoreReturnInutilizationCte {

    @Override
    protected CteInutilizationStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
