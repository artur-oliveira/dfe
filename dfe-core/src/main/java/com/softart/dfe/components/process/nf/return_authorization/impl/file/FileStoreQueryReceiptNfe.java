package com.softart.dfe.components.process.nf.return_authorization.impl.file;

import com.softart.dfe.components.process.nf.return_authorization.StoreSendQueryReceiptNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfReturnAuthorizationStorage;

final class FileStoreQueryReceiptNfe extends StoreSendQueryReceiptNfe {

    public NfReturnAuthorizationStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
