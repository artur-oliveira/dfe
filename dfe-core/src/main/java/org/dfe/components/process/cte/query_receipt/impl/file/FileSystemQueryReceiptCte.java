package org.dfe.components.process.cte.query_receipt.impl.file;

import org.dfe.components.process.cte.query_receipt.StoreQueryReceiptCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteQueryReceiptStorage;

final class FileSystemQueryReceiptCte extends StoreQueryReceiptCte {

    @Override
    protected CteQueryReceiptStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
