package org.dfe.components.process.cte.query_receipt.impl.s3;

import org.dfe.components.process.cte.query_receipt.StoreReturnQueryReceiptCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteQueryReceiptStorage;

final class S3StoreReturnQueryReceiptCte extends StoreReturnQueryReceiptCte {

    @Override
    protected CteQueryReceiptStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
