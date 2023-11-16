package org.dfe.components.process.nf.inut.impl.s3;

import org.dfe.components.process.nf.inut.StoreProcInutilizationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfInutStorage;

final class S3StoreProcInutNfe extends StoreProcInutilizationNfe {

    public NfInutStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
