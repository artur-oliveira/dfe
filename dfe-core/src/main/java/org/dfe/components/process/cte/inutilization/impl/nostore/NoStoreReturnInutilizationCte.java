package org.dfe.components.process.cte.inutilization.impl.nostore;

import org.dfe.components.process.cte.inutilization.StoreReturnInutilizationCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteInutilizationStorage;

final class NoStoreReturnInutilizationCte extends StoreReturnInutilizationCte {

    @Override
    protected CteInutilizationStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
