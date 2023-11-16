package org.dfe.components.process.nf.substitute_cancel.impl.s3;

import org.dfe.components.process.nf.substitute_cancel.StoreProcSubstituteCancelNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;

final class S3StoreProcSubstituteCancelNfe extends StoreProcSubstituteCancelNfe {
    @Override
    public NfceSubstituteCancelStorage getStorage() {
        return StorageFactory.s3().getNfceStorage();
    }
}
