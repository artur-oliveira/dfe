package org.dfe.components.process.cte.query_situation.impl.nostore;

import org.dfe.components.process.cte.query_situation.StoreReturnQuerySituationCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteQuerySituationStorage;

final class NoStoreReturnQuerySituationCte extends StoreReturnQuerySituationCte {

    @Override
    protected CteQuerySituationStorage getStorage() {
        return StorageFactory.noStorage().getCteStorage();
    }
}
