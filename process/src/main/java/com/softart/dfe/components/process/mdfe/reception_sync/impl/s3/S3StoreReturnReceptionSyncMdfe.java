package com.softart.dfe.components.process.mdfe.reception_sync.impl.s3;

import com.softart.dfe.components.process.mdfe.reception_sync.StoreReturnReceptionSyncMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreReturnReceptionSyncMdfe extends StoreReturnReceptionSyncMdfe {

    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
