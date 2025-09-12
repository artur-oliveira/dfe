package org.dfe.components.process.nf.event.impl.s3;

import org.dfe.components.process.nf.event.StoreProcEventNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.common.NfEventStorage;

final class S3ProcEventNfe extends StoreProcEventNfe {
    @Override
    public NfEventStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
