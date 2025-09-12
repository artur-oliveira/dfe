package org.dfe.components.process.mdfe.query_situation.impl.file;

import lombok.Getter;
import org.dfe.components.process.mdfe.query_situation.StoreReturnQuerySituationMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class FileSystemStoreReturnQuerySituationMdfe extends StoreReturnQuerySituationMdfe {

    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
