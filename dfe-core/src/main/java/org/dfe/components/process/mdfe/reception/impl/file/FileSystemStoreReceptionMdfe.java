package org.dfe.components.process.mdfe.reception.impl.file;

import lombok.Getter;
import org.dfe.components.process.mdfe.reception.StoreReceptionMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class FileSystemStoreReceptionMdfe extends StoreReceptionMdfe {
    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
