package org.dfe.components.process.mdfe.distribution.impl.nostore;

import lombok.Getter;
import org.dfe.components.process.mdfe.distribution.StoreReturnDistributionMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class NoStoreReturnDistributionMdfe extends StoreReturnDistributionMdfe {

    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
