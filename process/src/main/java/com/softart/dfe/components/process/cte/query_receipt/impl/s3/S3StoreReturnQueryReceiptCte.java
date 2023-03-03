package com.softart.dfe.components.process.cte.query_receipt.impl.s3;

import com.softart.dfe.components.process.cte.query_receipt.StoreReturnQueryReceiptCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteQueryReceiptStorage;

final class S3StoreReturnQueryReceiptCte extends StoreReturnQueryReceiptCte {

    @Override
    protected CteQueryReceiptStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
