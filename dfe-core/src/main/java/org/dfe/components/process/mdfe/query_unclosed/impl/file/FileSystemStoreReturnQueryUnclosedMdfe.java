package org.dfe.components.process.mdfe.query_unclosed.impl.file;

import lombok.Getter;
import org.dfe.components.process.mdfe.query_unclosed.StoreReturnQueryUnclosedMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class FileSystemStoreReturnQueryUnclosedMdfe extends StoreReturnQueryUnclosedMdfe {

    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
