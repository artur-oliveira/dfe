package com.softart.dfe.components.process.mdfe.distribution.impl.nostore;

import com.softart.dfe.components.process.mdfe.distribution.StoreDistributionMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreDistributionMdfe extends StoreDistributionMdfe {
    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
