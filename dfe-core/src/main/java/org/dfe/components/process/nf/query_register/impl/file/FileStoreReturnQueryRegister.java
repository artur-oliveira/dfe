package org.dfe.components.process.nf.query_register.impl.file;

import org.dfe.components.process.nf.query_register.StoreReturnQueryRegisterNf;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfeQueryRegisterStorage;

final class FileStoreReturnQueryRegister extends StoreReturnQueryRegisterNf {

    public NfeQueryRegisterStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
