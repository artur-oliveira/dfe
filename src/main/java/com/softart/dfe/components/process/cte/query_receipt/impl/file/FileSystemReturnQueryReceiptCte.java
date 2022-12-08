package com.softart.dfe.components.process.cte.query_receipt.impl.file;

import com.softart.dfe.components.process.cte.query_receipt.StoreReturnQueryReceiptCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteQueryReceiptStorage;

final class FileSystemReturnQueryReceiptCte extends StoreReturnQueryReceiptCte {

    @Override
    protected CteQueryReceiptStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
