package com.softart.dfe.components.process.mdfe.distribution.impl.file;

import com.softart.dfe.components.process.mdfe.distribution.StoreReturnDistributionMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class FileSystemStoreReturnDistributionMdfe extends StoreReturnDistributionMdfe {

    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
