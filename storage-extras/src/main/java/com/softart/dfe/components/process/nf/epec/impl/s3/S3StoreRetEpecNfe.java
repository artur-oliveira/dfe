package com.softart.dfe.components.process.nf.epec.impl.s3;

import com.softart.dfe.components.process.nf.epec.StoreRetEpecNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeEpecStorage;

final class S3StoreRetEpecNfe extends StoreRetEpecNfe {
    @Override
    public NfeEpecStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
