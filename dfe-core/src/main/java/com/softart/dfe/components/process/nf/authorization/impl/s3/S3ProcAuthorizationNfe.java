package com.softart.dfe.components.process.nf.authorization.impl.s3;

import com.softart.dfe.components.process.nf.authorization.StoreProcAuthorizationNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;

final class S3ProcAuthorizationNfe extends StoreProcAuthorizationNfe {

    public NfAuthorizationStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
