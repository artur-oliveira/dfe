package org.dfe.components.process.mdfe.event.impl.file;

import lombok.Getter;
import org.dfe.components.process.mdfe.event.StoreProcEventMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class FileSystemStoreProcEventMdfe extends StoreProcEventMdfe {

    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
