package org.dfe.components.process.mdfe.event.impl.nostore;

import org.dfe.components.process.mdfe.event.StoreReturnEventMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreReturnEventMdfe extends StoreReturnEventMdfe {

    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
