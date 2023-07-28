package com.softart.dfe.components.process.cte4.query_situation.impl.s3;

import com.softart.dfe.components.process.cte4.query_situation.StoreQuerySituationCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteQuerySituationStorage;

final class S3StoreQuerySituationCte extends StoreQuerySituationCte {

    @Override
    protected CteQuerySituationStorage getStorage() {
        return StorageFactory.s3().getCte4Storage();
    }
}
