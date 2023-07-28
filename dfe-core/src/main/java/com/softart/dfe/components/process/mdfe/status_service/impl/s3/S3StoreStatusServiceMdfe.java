package com.softart.dfe.components.process.mdfe.status_service.impl.s3;

import com.softart.dfe.components.process.mdfe.status_service.StoreStatusServiceMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreStatusServiceMdfe extends StoreStatusServiceMdfe {
    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
