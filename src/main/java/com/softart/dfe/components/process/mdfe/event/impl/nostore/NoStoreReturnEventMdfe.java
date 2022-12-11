package com.softart.dfe.components.process.mdfe.event.impl.nostore;

import com.softart.dfe.components.process.mdfe.event.StoreReturnEventMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreReturnEventMdfe extends StoreReturnEventMdfe {

    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
