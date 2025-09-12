package org.dfe.components.process.mdfe.query_receipt.impl.nostore;

import lombok.Getter;
import org.dfe.components.process.mdfe.query_receipt.StoreReturnQueryReceiptMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class NoStoreReturnQueryReceiptMdfe extends StoreReturnQueryReceiptMdfe {

    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
