package org.dfe.components.process.cte.query_situation.impl.nostore;

import org.dfe.components.process.cte.query_situation.StoreQuerySituationCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteQuerySituationStorage;

final class NoStoreQuerySituationCte extends StoreQuerySituationCte {

    @Override
    protected CteQuerySituationStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
