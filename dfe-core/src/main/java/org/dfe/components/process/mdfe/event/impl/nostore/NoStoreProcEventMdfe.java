package org.dfe.components.process.mdfe.event.impl.nostore;

import org.dfe.components.process.mdfe.event.StoreProcEventMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreProcEventMdfe extends StoreProcEventMdfe {

    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
