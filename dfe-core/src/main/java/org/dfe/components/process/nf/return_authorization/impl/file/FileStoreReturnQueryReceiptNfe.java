package org.dfe.components.process.nf.return_authorization.impl.file;

import org.dfe.components.process.nf.return_authorization.StoreReturnQueryReceiptNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfReturnAuthorizationStorage;

final class FileStoreReturnQueryReceiptNfe extends StoreReturnQueryReceiptNfe {

    public NfReturnAuthorizationStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
