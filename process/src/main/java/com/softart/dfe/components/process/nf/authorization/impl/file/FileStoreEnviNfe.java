package com.softart.dfe.components.process.nf.authorization.impl.file;

import com.softart.dfe.components.process.nf.authorization.StoreAuthorizationNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;

public final class FileStoreEnviNfe extends StoreAuthorizationNfe {
    public NfAuthorizationStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }

}
