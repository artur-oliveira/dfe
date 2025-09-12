package org.dfe.components.process.mdfe.status_service.impl.s3;

import lombok.Getter;
import org.dfe.components.process.mdfe.status_service.StoreReturnStatusServiceMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;

@Getter
final class S3StoreReturnStatusServiceMdfe extends StoreReturnStatusServiceMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
