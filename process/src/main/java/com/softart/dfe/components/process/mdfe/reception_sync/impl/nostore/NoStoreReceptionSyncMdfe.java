package com.softart.dfe.components.process.mdfe.reception_sync.impl.nostore;

import com.softart.dfe.components.process.mdfe.reception_sync.StoreReceptionSyncMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreReceptionSyncMdfe extends StoreReceptionSyncMdfe {
    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
