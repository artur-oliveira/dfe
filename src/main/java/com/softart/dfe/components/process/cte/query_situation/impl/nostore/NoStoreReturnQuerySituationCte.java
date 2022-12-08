package com.softart.dfe.components.process.cte.query_situation.impl.nostore;

import com.softart.dfe.components.process.cte.query_situation.StoreReturnQuerySituationCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteQuerySituationStorage;

final class NoStoreReturnQuerySituationCte extends StoreReturnQuerySituationCte {

    @Override
    protected CteQuerySituationStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
