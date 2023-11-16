package org.dfe.components.process.nf.return_authorization.impl.s3;

import org.dfe.components.process.nf.return_authorization.StoreReturnQueryReceiptNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfReturnAuthorizationStorage;

final class S3StoreReturnQueryReceiptNfe extends StoreReturnQueryReceiptNfe {

    public NfReturnAuthorizationStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
