package com.softart.dfe.components.process.mdfe.reception_sync.impl.file;

import com.softart.dfe.components.process.mdfe.reception_sync.StoreReturnReceptionSyncMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class FileSystemStoreReturnReceptionSyncMdfe extends StoreReturnReceptionSyncMdfe {

    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
