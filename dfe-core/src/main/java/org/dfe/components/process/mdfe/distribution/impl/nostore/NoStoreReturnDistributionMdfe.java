package org.dfe.components.process.mdfe.distribution.impl.nostore;

import org.dfe.components.process.mdfe.distribution.StoreReturnDistributionMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreReturnDistributionMdfe extends StoreReturnDistributionMdfe {

    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
