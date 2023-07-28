package com.softart.dfe.components.process.cte4.query_situation.impl.nostore;

import com.softart.dfe.components.process.cte4.query_situation.StoreQuerySituationCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteQuerySituationStorage;

final class NoStoreQuerySituationCte extends StoreQuerySituationCte {

    @Override
    protected CteQuerySituationStorage getStorage() {
        return StorageFactory.noStorage().getCte4Storage();
    }
}
