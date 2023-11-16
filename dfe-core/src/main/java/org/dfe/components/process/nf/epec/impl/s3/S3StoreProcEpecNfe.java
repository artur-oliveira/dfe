package org.dfe.components.process.nf.epec.impl.s3;

import org.dfe.components.process.nf.epec.StoreProcEpecNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeEpecStorage;

final class S3StoreProcEpecNfe extends StoreProcEpecNfe {
    @Override
    public NfeEpecStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
