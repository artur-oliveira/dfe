package org.dfe.components.process.cte4.reception_gtve.impl.nostore;

import org.dfe.components.process.cte4.reception_gtve.StoreProcGtve;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteReceptionGtveStorage;

final class NoStoreProcGtve extends StoreProcGtve {

    @Override
    protected CteReceptionGtveStorage getStorage() {
        return StorageFactory.noStorage().getCte4Storage();
    }
}
