package org.dfe.components.process.mdfe.reception_sync.impl.file;

import lombok.Getter;
import org.dfe.components.process.mdfe.reception_sync.StoreReturnReceptionSyncMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class FileSystemStoreReturnReceptionSyncMdfe extends StoreReturnReceptionSyncMdfe {

    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
