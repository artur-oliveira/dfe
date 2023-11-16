package org.dfe.components.process.cte.query_receipt.impl.s3;

import org.dfe.components.process.cte.query_receipt.StoreQueryReceiptCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteQueryReceiptStorage;

final class S3StoreQueryReceiptCte extends StoreQueryReceiptCte {

    @Override
    protected CteQueryReceiptStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
