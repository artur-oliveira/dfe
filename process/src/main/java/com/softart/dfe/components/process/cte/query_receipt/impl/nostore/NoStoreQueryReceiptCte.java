package com.softart.dfe.components.process.cte.query_receipt.impl.nostore;

import com.softart.dfe.components.process.cte.query_receipt.StoreQueryReceiptCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteQueryReceiptStorage;

final class NoStoreQueryReceiptCte extends StoreQueryReceiptCte {

    @Override
    protected CteQueryReceiptStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
