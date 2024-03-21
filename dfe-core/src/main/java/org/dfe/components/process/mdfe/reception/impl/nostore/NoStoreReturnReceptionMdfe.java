package org.dfe.components.process.mdfe.reception.impl.nostore;

import lombok.Getter;
import org.dfe.components.process.mdfe.reception.StoreReturnReceptionMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class NoStoreReturnReceptionMdfe extends StoreReturnReceptionMdfe {

    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
