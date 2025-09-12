package org.dfe.components.process.mdfe.query_receipt.impl.s3;

import lombok.Getter;
import org.dfe.components.process.mdfe.query_receipt.StoreQueryReceiptMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class S3StoreQueryReceiptMdfe extends StoreQueryReceiptMdfe {
    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
