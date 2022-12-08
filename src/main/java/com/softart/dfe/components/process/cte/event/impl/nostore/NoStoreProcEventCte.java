package com.softart.dfe.components.process.cte.event.impl.nostore;

import com.softart.dfe.components.process.cte.event.StoreProcEventCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteEventStorage;

final class NoStoreProcEventCte extends StoreProcEventCte {

    @Override
    protected CteEventStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
