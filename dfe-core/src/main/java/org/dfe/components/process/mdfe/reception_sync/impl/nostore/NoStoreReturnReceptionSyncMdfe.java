package org.dfe.components.process.mdfe.reception_sync.impl.nostore;

import org.dfe.components.process.mdfe.reception_sync.StoreReturnReceptionSyncMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreReturnReceptionSyncMdfe extends StoreReturnReceptionSyncMdfe {

    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
