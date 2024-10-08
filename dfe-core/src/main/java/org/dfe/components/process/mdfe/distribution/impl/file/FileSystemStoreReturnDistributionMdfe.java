package org.dfe.components.process.mdfe.distribution.impl.file;

import org.dfe.components.process.mdfe.distribution.StoreReturnDistributionMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class FileSystemStoreReturnDistributionMdfe extends StoreReturnDistributionMdfe {

    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
