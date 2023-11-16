package org.dfe.components.process.nf.return_authorization.impl.s3;

import org.dfe.components.process.nf.return_authorization.StoreSendQueryReceiptNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfReturnAuthorizationStorage;

final class S3StoreQueryReceiptNfe extends StoreSendQueryReceiptNfe {

    public NfReturnAuthorizationStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
