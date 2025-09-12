package org.dfe.components.process.mdfe.reception_sync.impl.nostore;

import lombok.Getter;
import org.dfe.components.process.mdfe.reception_sync.StoreReceptionSyncMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class NoStoreReceptionSyncMdfe extends StoreReceptionSyncMdfe {
    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
