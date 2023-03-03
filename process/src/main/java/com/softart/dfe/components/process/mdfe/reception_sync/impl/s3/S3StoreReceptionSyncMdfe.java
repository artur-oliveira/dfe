package com.softart.dfe.components.process.mdfe.reception_sync.impl.s3;

import com.softart.dfe.components.process.mdfe.reception_sync.StoreReceptionSyncMdfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStorage;
import lombok.Getter;

@Getter
final class S3StoreReceptionSyncMdfe extends StoreReceptionSyncMdfe {
    private final MdfeStorage storage = StorageFactory.s3().getMdfeStorage();

}
