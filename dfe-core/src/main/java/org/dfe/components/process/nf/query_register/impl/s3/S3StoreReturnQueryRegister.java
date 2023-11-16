package org.dfe.components.process.nf.query_register.impl.s3;

import org.dfe.components.process.nf.query_register.StoreReturnQueryRegisterNf;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfeQueryRegisterStorage;

final class S3StoreReturnQueryRegister extends StoreReturnQueryRegisterNf {

    public NfeQueryRegisterStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
