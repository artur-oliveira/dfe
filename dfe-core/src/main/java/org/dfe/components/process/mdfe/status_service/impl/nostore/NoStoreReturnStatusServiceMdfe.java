package org.dfe.components.process.mdfe.status_service.impl.nostore;

import org.dfe.components.process.mdfe.status_service.StoreReturnStatusServiceMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreReturnStatusServiceMdfe extends StoreReturnStatusServiceMdfe {

    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
