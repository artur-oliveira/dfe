package org.dfe.components.process.nf.query_register.impl.nostore;

import org.dfe.components.process.nf.query_register.StoreReturnQueryRegisterNf;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfeQueryRegisterStorage;

final class NoStoreReturnQueryRegister extends StoreReturnQueryRegisterNf {

    public NfeQueryRegisterStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
