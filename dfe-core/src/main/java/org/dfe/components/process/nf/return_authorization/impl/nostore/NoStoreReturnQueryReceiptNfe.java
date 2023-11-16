package org.dfe.components.process.nf.return_authorization.impl.nostore;

import org.dfe.components.process.nf.return_authorization.StoreReturnQueryReceiptNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfReturnAuthorizationStorage;

final class NoStoreReturnQueryReceiptNfe extends StoreReturnQueryReceiptNfe {

    public NfReturnAuthorizationStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
