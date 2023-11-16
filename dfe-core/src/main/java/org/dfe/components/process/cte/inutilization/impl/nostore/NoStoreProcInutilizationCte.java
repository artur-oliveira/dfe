package org.dfe.components.process.cte.inutilization.impl.nostore;

import org.dfe.components.process.cte.inutilization.StoreProcInutilizationCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteInutilizationStorage;

final class NoStoreProcInutilizationCte extends StoreProcInutilizationCte {

    @Override
    protected CteInutilizationStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
