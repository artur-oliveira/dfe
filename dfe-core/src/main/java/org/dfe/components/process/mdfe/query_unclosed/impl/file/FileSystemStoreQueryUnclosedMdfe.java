package org.dfe.components.process.mdfe.query_unclosed.impl.file;

import org.dfe.components.process.mdfe.query_unclosed.StoreQueryUnclosedMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class FileSystemStoreQueryUnclosedMdfe extends StoreQueryUnclosedMdfe {
    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
