package org.dfe.components.process.nf.authorization.impl.nostore;

import org.dfe.components.process.nf.authorization.StoreAuthorizationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;

final class NoStoreAuthorizationNfe extends StoreAuthorizationNfe {

    public NfAuthorizationStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }

}
