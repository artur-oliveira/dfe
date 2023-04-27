package com.softart.dfe.components.process.cte.query_receipt.impl.s3;

import com.softart.dfe.components.process.cte.query_receipt.StoreQueryReceiptCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteQueryReceiptStorage;

final class S3StoreQueryReceiptCte extends StoreQueryReceiptCte {

    @Override
    protected CteQueryReceiptStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
