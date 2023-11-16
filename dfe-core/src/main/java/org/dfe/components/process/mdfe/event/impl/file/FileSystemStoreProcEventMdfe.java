package org.dfe.components.process.mdfe.event.impl.file;

import org.dfe.components.process.mdfe.event.StoreProcEventMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class FileSystemStoreProcEventMdfe extends StoreProcEventMdfe {

    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
