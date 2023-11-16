package org.dfe.components.process.nf.return_authorization.impl.nostore;

import org.dfe.components.process.nf.return_authorization.StoreSendQueryReceiptNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfReturnAuthorizationStorage;

final class NoStoreQueryReceiptNfe extends StoreSendQueryReceiptNfe {

    public NfReturnAuthorizationStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }

}
