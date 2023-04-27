package com.softart.dfe.components.process.mdfe.event.impl.file;

import com.softart.dfe.components.process.mdfe.event.StoreReturnEventMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class FileSystemStoreReturnEventMdfe extends StoreReturnEventMdfe {

    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
