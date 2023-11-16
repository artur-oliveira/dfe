package org.dfe.components.process.cte.inutilization.impl.nostore;

import org.dfe.components.process.cte.inutilization.StoreInutilizationCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteInutilizationStorage;

final class NoStoreInutilizationCte extends StoreInutilizationCte {

    @Override
    protected CteInutilizationStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
