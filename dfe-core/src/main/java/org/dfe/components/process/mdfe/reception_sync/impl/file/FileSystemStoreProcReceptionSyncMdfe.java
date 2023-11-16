package org.dfe.components.process.mdfe.reception_sync.impl.file;

import org.dfe.components.process.mdfe.reception_sync.StoreProcMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class FileSystemStoreProcReceptionSyncMdfe extends StoreProcMdfe {

    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
