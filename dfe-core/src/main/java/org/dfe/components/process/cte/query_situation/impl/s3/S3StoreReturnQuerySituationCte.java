package org.dfe.components.process.cte.query_situation.impl.s3;

import org.dfe.components.process.cte.query_situation.StoreReturnQuerySituationCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteQuerySituationStorage;

final class S3StoreReturnQuerySituationCte extends StoreReturnQuerySituationCte {

    @Override
    protected CteQuerySituationStorage getStorage() {
        return StorageFactory.s3().getCteStorage();
    }
}
