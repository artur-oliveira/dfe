package org.dfe.components.process.mdfe.reception.impl.file;

import org.dfe.components.process.mdfe.reception.StoreReceptionMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class FileSystemStoreReceptionMdfe extends StoreReceptionMdfe {
    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
