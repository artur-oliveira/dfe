package com.softart.dfe.components.process.mdfe.query_receipt.impl.nostore;

import com.softart.dfe.components.process.mdfe.query_receipt.StoreQueryReceiptMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreQueryReceiptMdfe extends StoreQueryReceiptMdfe {
    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
