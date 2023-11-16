package org.dfe.components.process.cte4.reception_gtve.impl.nostore;

import org.dfe.components.process.cte4.reception_gtve.StoreGtve;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteReceptionGtveStorage;

final class NoStoreGtve extends StoreGtve {

    @Override
    protected CteReceptionGtveStorage getStorage() {
        return StorageFactory.noStorage().getCte4Storage();
    }
}
