package org.dfe.components.process.mdfe.distribution.impl.file;

import lombok.Getter;
import org.dfe.components.process.mdfe.distribution.StoreReturnDistributionMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class FileSystemStoreReturnDistributionMdfe extends StoreReturnDistributionMdfe {

    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
