package com.softart.dfe.components.process.nf.return_authorization.impl.file;

import com.softart.dfe.components.process.nf.return_authorization.StoreReturnQueryReceiptNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfReturnAuthorizationStorage;

final class FileStoreReturnQueryReceiptNfe extends StoreReturnQueryReceiptNfe {

    public NfReturnAuthorizationStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
