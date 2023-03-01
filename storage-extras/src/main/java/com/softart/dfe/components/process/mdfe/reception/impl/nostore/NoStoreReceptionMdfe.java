package com.softart.dfe.components.process.mdfe.reception.impl.nostore;

import com.softart.dfe.components.process.mdfe.reception.StoreReceptionMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreReceptionMdfe extends StoreReceptionMdfe {
    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
