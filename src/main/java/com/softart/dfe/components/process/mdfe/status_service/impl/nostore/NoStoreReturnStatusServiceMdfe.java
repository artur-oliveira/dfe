package com.softart.dfe.components.process.mdfe.status_service.impl.nostore;

import com.softart.dfe.components.process.mdfe.status_service.StoreReturnStatusServiceMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class NoStoreReturnStatusServiceMdfe extends StoreReturnStatusServiceMdfe {

    private final MdfeStorage storage = StorageFactory.noStorage().getMdfeStorage();

}
