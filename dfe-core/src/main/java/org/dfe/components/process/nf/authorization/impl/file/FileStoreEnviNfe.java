package org.dfe.components.process.nf.authorization.impl.file;

import org.dfe.components.process.nf.authorization.StoreAuthorizationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;

public final class FileStoreEnviNfe extends StoreAuthorizationNfe {
    public NfAuthorizationStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }

}
