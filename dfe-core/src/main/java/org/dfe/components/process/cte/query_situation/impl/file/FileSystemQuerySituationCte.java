package org.dfe.components.process.cte.query_situation.impl.file;

import org.dfe.components.process.cte.query_situation.StoreQuerySituationCte;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.cte.CteQuerySituationStorage;

final class FileSystemQuerySituationCte extends StoreQuerySituationCte {

    @Override
    protected CteQuerySituationStorage getStorage() {
        return StorageFactory.fileSystem().getCteStorage();
    }
}
