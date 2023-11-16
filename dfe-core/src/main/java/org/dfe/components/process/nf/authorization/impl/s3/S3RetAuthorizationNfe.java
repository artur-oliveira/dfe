package org.dfe.components.process.nf.authorization.impl.s3;

import org.dfe.components.process.nf.authorization.StoreRetAuthorizationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;

final class S3RetAuthorizationNfe extends StoreRetAuthorizationNfe {

    public NfAuthorizationStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
