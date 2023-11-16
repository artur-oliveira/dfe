package org.dfe.components.process.mdfe.query_receipt.impl.file;

import org.dfe.components.process.mdfe.query_receipt.StoreReturnQueryReceiptMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class FileSystemStoreReturnQueryReceiptMdfe extends StoreReturnQueryReceiptMdfe {

    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
