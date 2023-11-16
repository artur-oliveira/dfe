package org.dfe.components.process.nf.query_register.impl.nostore;

import org.dfe.components.process.nf.query_register.StoreQueryRegisterNf;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfeQueryRegisterStorage;

final class NoStoreQueryRegister extends StoreQueryRegisterNf {

    public NfeQueryRegisterStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }

}
