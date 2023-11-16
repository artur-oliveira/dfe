package org.dfe.components.process.mdfe.reception_sync.impl.s3;

import org.dfe.components.process.mdfe.reception_sync.StoreReturnReceptionSyncMdfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreReturnReceptionSyncMdfe extends StoreReturnReceptionSyncMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
