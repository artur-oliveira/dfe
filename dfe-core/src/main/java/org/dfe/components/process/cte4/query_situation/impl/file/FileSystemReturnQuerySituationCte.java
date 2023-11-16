package org.dfe.components.process.cte4.query_situation.impl.file;

import org.dfe.components.process.cte4.query_situation.StoreReturnQuerySituationCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte4.CteQuerySituationStorage;

final class FileSystemReturnQuerySituationCte extends StoreReturnQuerySituationCte {

    @Override
    protected CteQuerySituationStorage getStorage() {
        return StorageFactory.fileSystem().getCte4Storage();
    }
}
