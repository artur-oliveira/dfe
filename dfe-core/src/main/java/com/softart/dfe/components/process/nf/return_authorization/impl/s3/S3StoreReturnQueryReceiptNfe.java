package com.softart.dfe.components.process.nf.return_authorization.impl.s3;

import com.softart.dfe.components.process.nf.return_authorization.StoreReturnQueryReceiptNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfReturnAuthorizationStorage;

final class S3StoreReturnQueryReceiptNfe extends StoreReturnQueryReceiptNfe {

    public NfReturnAuthorizationStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
