package org.dfe.components.process.cte.reception_gtve.impl.nostore;

import org.dfe.components.process.cte.reception_gtve.StoreProcGtve;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionGtveStorage;

final class NoStoreProcGtve extends StoreProcGtve {

    @Override
    protected CteReceptionGtveStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
