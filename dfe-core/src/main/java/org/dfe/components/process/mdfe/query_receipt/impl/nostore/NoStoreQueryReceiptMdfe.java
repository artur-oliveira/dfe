package org.dfe.components.process.mdfe.query_receipt.impl.nostore;

import org.dfe.components.process.mdfe.query_receipt.StoreQueryReceiptMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreQueryReceiptMdfe extends StoreQueryReceiptMdfe {
    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
