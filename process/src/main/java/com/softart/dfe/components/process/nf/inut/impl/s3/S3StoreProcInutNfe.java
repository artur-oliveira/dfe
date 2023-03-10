package com.softart.dfe.components.process.nf.inut.impl.s3;

import com.softart.dfe.components.process.nf.inut.StoreProcInutilizationNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfInutStorage;

final class S3StoreProcInutNfe extends StoreProcInutilizationNfe {

    public NfInutStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
