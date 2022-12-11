package com.softart.dfe.components.process.mdfe.status_service.impl.file;

import com.softart.dfe.components.process.mdfe.status_service.StoreStatusServiceMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class FileSystemStoreStatusServiceMdfe extends StoreStatusServiceMdfe {
    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
