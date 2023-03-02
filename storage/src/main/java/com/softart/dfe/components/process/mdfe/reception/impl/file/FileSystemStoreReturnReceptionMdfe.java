package com.softart.dfe.components.process.mdfe.reception.impl.file;

import com.softart.dfe.components.process.mdfe.reception.StoreReturnReceptionMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class FileSystemStoreReturnReceptionMdfe extends StoreReturnReceptionMdfe {

    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
