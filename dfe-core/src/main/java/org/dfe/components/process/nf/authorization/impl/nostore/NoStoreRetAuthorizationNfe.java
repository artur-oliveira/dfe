package org.dfe.components.process.nf.authorization.impl.nostore;

import org.dfe.components.process.nf.authorization.StoreRetAuthorizationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;

final class NoStoreRetAuthorizationNfe extends StoreRetAuthorizationNfe {

    public NfAuthorizationStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
