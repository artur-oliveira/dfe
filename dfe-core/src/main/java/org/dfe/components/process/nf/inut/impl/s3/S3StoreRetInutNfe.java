package org.dfe.components.process.nf.inut.impl.s3;

import org.dfe.components.process.nf.inut.StoreRetInutilizationNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfInutStorage;

final class S3StoreRetInutNfe extends StoreRetInutilizationNfe {

    public NfInutStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
