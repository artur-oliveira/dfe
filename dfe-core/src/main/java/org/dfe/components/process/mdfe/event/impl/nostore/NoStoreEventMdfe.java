package org.dfe.components.process.mdfe.event.impl.nostore;

import org.dfe.components.process.mdfe.event.StoreEventMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreEventMdfe extends StoreEventMdfe {
    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
