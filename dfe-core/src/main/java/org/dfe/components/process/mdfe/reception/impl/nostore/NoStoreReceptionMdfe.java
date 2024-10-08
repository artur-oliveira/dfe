package org.dfe.components.process.mdfe.reception.impl.nostore;

import org.dfe.components.process.mdfe.reception.StoreReceptionMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreReceptionMdfe extends StoreReceptionMdfe {
    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
