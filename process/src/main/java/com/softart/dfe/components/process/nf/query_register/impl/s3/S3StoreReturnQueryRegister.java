package com.softart.dfe.components.process.nf.query_register.impl.s3;

import com.softart.dfe.components.process.nf.query_register.StoreReturnQueryRegisterNf;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfeQueryRegisterStorage;

final class S3StoreReturnQueryRegister extends StoreReturnQueryRegisterNf {

    public NfeQueryRegisterStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
