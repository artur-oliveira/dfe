package org.dfe.components.process.cte4.query_situation.impl.nostore;

import org.dfe.components.process.cte4.query_situation.StoreQuerySituationCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteQuerySituationStorage;

final class NoStoreQuerySituationCte extends StoreQuerySituationCte {

    @Override
    protected CteQuerySituationStorage getStorage() {
        return StorageFactory.noStorage().getCte4Storage();
    }
}
