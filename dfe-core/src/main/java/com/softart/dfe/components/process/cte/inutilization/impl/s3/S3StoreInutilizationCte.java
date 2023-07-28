package com.softart.dfe.components.process.cte.inutilization.impl.s3;

import com.softart.dfe.components.process.cte.inutilization.StoreInutilizationCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteInutilizationStorage;

final class S3StoreInutilizationCte extends StoreInutilizationCte {

    @Override
    protected CteInutilizationStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
