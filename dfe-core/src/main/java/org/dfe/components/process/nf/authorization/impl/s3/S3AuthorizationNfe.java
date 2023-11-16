package org.dfe.components.process.nf.authorization.impl.s3;

import org.dfe.components.process.nf.authorization.StoreAuthorizationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;

public final class S3AuthorizationNfe extends StoreAuthorizationNfe {
    public NfAuthorizationStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }

}
