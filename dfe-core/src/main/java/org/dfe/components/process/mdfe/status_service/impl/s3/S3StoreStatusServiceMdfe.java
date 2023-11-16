package org.dfe.components.process.mdfe.status_service.impl.s3;

import org.dfe.components.process.mdfe.status_service.StoreStatusServiceMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreStatusServiceMdfe extends StoreStatusServiceMdfe {
    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
