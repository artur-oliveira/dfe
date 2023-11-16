package org.dfe.components.process.cte.reception_gtve.impl.nostore;

import org.dfe.components.process.cte.reception_gtve.StoreGtve;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteReceptionGtveStorage;

final class NoStoreGtve extends StoreGtve {

    @Override
    protected CteReceptionGtveStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
