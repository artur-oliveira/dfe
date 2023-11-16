package org.dfe.components.process.mdfe.query_situation.impl.file;

import org.dfe.components.process.mdfe.query_situation.StoreReturnQuerySituationMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class FileSystemStoreReturnQuerySituationMdfe extends StoreReturnQuerySituationMdfe {

    private final MdfeStorage storage = StorageFactory.fileSystem().getMdfeStorage();

}
