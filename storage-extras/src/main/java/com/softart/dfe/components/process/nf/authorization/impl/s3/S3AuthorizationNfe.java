package com.softart.dfe.components.process.nf.authorization.impl.s3;

import com.softart.dfe.components.process.nf.authorization.StoreAuthorizationNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;

public final class S3AuthorizationNfe extends StoreAuthorizationNfe {
    public NfAuthorizationStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }

}
