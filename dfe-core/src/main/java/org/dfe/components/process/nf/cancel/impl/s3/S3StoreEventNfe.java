package org.dfe.components.process.nf.cancel.impl.s3;

import org.dfe.components.process.nf.cancel.StoreSendCancelNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfCancelStorage;

final class S3StoreEventNfe extends StoreSendCancelNfe {
    @Override
    public NfCancelStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
