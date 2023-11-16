package org.dfe.components.process.mdfe.reception_sync.impl.nostore;

import org.dfe.components.process.mdfe.reception_sync.StoreProcMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreProcMdfe extends StoreProcMdfe {

    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
