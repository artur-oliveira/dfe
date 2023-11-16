package org.dfe.components.process.nf.cancel.impl.s3;

import org.dfe.components.process.nf.cancel.StoreProcCancelNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfCancelStorage;

final class S3ProcEventNfe extends StoreProcCancelNfe {
    @Override
    public NfCancelStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
