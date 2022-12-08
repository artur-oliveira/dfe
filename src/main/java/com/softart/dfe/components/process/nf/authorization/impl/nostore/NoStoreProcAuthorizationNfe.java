package com.softart.dfe.components.process.nf.authorization.impl.nostore;

import com.softart.dfe.components.process.nf.authorization.StoreProcAuthorizationNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;

final class NoStoreProcAuthorizationNfe extends StoreProcAuthorizationNfe {

    public NfAuthorizationStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
