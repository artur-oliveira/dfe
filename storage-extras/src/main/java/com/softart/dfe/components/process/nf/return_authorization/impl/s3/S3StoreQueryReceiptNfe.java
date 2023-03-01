package com.softart.dfe.components.process.nf.return_authorization.impl.s3;

import com.softart.dfe.components.process.nf.return_authorization.StoreSendQueryReceiptNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfReturnAuthorizationStorage;

final class S3StoreQueryReceiptNfe extends StoreSendQueryReceiptNfe {

    public NfReturnAuthorizationStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
