package com.softart.dfe.components.process.nf.authorization.impl.file;

import com.softart.dfe.components.process.nf.authorization.StoreRetAuthorizationNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;

final class FileStoreRetAuthorizationNfe extends StoreRetAuthorizationNfe {

    public NfAuthorizationStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
