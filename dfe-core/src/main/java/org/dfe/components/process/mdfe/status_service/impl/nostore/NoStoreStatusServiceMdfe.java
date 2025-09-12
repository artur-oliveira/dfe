package org.dfe.components.process.mdfe.status_service.impl.nostore;

import lombok.Getter;
import org.dfe.components.process.mdfe.status_service.StoreStatusServiceMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class NoStoreStatusServiceMdfe extends StoreStatusServiceMdfe {
    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
