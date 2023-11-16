package org.dfe.components.process.mdfe.distribution.impl.file;

import org.dfe.components.process.mdfe.distribution.StoreDistributionMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class FileSystemStoreDistributionMdfe extends StoreDistributionMdfe {
    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
