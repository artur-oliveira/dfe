package org.dfe.components.process.nf.authorization.impl.file;

import org.dfe.components.process.nf.authorization.StoreProcAuthorizationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;

final class FileStoreProcAuthorizationNfe extends StoreProcAuthorizationNfe {

    public NfAuthorizationStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
