package com.softart.dfe.components.process.cte.query_situation.impl.s3;

import com.softart.dfe.components.process.cte.query_situation.StoreQuerySituationCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteQuerySituationStorage;

final class S3StoreQuerySituationCte extends StoreQuerySituationCte {

    @Override
    protected CteQuerySituationStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
