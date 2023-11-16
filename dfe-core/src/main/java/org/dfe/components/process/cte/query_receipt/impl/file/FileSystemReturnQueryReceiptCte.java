package org.dfe.components.process.cte.query_receipt.impl.file;

import org.dfe.components.process.cte.query_receipt.StoreReturnQueryReceiptCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteQueryReceiptStorage;

final class FileSystemReturnQueryReceiptCte extends StoreReturnQueryReceiptCte {

    @Override
    protected CteQueryReceiptStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
