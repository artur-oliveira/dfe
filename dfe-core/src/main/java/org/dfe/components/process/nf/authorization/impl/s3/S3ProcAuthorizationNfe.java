package org.dfe.components.process.nf.authorization.impl.s3;

import org.dfe.components.process.nf.authorization.StoreProcAuthorizationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;

final class S3ProcAuthorizationNfe extends StoreProcAuthorizationNfe {

    public NfAuthorizationStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
