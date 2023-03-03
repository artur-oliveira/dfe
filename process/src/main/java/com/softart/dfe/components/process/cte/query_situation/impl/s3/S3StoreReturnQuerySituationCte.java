package com.softart.dfe.components.process.cte.query_situation.impl.s3;

import com.softart.dfe.components.process.cte.query_situation.StoreReturnQuerySituationCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte.CteQuerySituationStorage;

final class S3StoreReturnQuerySituationCte extends StoreReturnQuerySituationCte {

    @Override
    protected CteQuerySituationStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
