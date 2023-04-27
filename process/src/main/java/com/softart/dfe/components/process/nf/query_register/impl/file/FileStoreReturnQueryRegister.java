package com.softart.dfe.components.process.nf.query_register.impl.file;

import com.softart.dfe.components.process.nf.query_register.StoreReturnQueryRegisterNf;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfeQueryRegisterStorage;

final class FileStoreReturnQueryRegister extends StoreReturnQueryRegisterNf {

    public NfeQueryRegisterStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
