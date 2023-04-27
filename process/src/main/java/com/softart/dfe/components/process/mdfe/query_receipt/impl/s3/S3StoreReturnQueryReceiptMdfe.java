package com.softart.dfe.components.process.mdfe.query_receipt.impl.s3;

import com.softart.dfe.components.process.mdfe.query_receipt.StoreReturnQueryReceiptMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreReturnQueryReceiptMdfe extends StoreReturnQueryReceiptMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
