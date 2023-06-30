package com.softart.dfe.components.process.cte.inutilization.impl.s3;

import com.softart.dfe.components.process.cte.inutilization.StoreReturnInutilizationCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteInutilizationStorage;

final class S3StoreReturnInutilizationCte extends StoreReturnInutilizationCte {

    @Override
    protected CteInutilizationStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
