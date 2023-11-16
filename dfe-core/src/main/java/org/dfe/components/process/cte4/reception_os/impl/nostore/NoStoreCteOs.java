package org.dfe.components.process.cte4.reception_os.impl.nostore;

import org.dfe.components.process.cte4.reception_os.StoreCteOs;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteReceptionOsStorage;

final class NoStoreCteOs extends StoreCteOs {

    @Override
    protected CteReceptionOsStorage getStorage() {
        return StorageFactory.noStorage().getCte4Storage();
    }
}
