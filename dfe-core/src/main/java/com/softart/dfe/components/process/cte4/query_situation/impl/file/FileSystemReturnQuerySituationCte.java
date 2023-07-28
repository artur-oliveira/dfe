package com.softart.dfe.components.process.cte4.query_situation.impl.file;

import com.softart.dfe.components.process.cte4.query_situation.StoreReturnQuerySituationCte;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.cte4.CteQuerySituationStorage;

final class FileSystemReturnQuerySituationCte extends StoreReturnQuerySituationCte {

    @Override
    protected CteQuerySituationStorage getStorage() {
        return StorageFactory.fileSystem().getCte4Storage();
    }
}
