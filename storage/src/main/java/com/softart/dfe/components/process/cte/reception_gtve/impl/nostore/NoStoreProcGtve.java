package com.softart.dfe.components.process.cte.reception_gtve.impl.nostore;

import com.softart.dfe.components.process.cte.reception_gtve.StoreProcGtve;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteReceptionGtveStorage;

final class NoStoreProcGtve extends StoreProcGtve {

    @Override
    protected CteReceptionGtveStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
