package org.dfe.components.process.nf.authorization.impl.nostore;

import org.dfe.components.process.nf.authorization.StoreProcAuthorizationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;

final class NoStoreProcAuthorizationNfe extends StoreProcAuthorizationNfe {

    public NfAuthorizationStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
