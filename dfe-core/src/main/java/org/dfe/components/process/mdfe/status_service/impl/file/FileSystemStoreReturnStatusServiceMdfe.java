package org.dfe.components.process.mdfe.status_service.impl.file;

import lombok.Getter;
import org.dfe.components.process.mdfe.status_service.StoreReturnStatusServiceMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class FileSystemStoreReturnStatusServiceMdfe extends StoreReturnStatusServiceMdfe {

    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
