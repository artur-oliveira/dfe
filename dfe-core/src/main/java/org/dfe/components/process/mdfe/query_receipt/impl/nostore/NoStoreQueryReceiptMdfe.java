package org.dfe.components.process.mdfe.query_receipt.impl.nostore;

import lombok.Getter;
import org.dfe.components.process.mdfe.query_receipt.StoreQueryReceiptMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class NoStoreQueryReceiptMdfe extends StoreQueryReceiptMdfe {
    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
