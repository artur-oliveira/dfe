package com.softart.dfe.components.process.nf.return_authorization.impl.nostore;

import com.softart.dfe.components.process.nf.return_authorization.StoreReturnQueryReceiptNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfReturnAuthorizationStorage;

final class NoStoreReturnQueryReceiptNfe extends StoreReturnQueryReceiptNfe {

    public NfReturnAuthorizationStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
