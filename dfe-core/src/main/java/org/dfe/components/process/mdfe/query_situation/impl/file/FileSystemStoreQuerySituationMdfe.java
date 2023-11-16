package org.dfe.components.process.mdfe.query_situation.impl.file;

import org.dfe.components.process.mdfe.query_situation.StoreQuerySituationMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class FileSystemStoreQuerySituationMdfe extends StoreQuerySituationMdfe {
    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
