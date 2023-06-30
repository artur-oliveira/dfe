package com.softart.dfe.components.process.nf.cancel.impl.s3;

import com.softart.dfe.components.process.nf.cancel.StoreSendCancelNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.common.NfCancelStorage;

final class S3StoreEventNfe extends StoreSendCancelNfe {
    @Override
    public NfCancelStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
