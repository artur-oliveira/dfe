package org.dfe.components.process.cte.query_receipt.impl.nostore;

import org.dfe.components.process.cte.query_receipt.StoreReturnQueryReceiptCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteQueryReceiptStorage;

final class NoStoreReturnQueryReceiptCte extends StoreReturnQueryReceiptCte {

    @Override
    protected CteQueryReceiptStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
