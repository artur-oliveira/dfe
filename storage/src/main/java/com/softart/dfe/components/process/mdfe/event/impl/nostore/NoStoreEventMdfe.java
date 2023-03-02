package com.softart.dfe.components.process.mdfe.event.impl.nostore;

import com.softart.dfe.components.process.mdfe.event.StoreEventMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreEventMdfe extends StoreEventMdfe {
    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
