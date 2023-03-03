package com.softart.dfe.components.process.nf.substitute_cancel.impl.s3;

import com.softart.dfe.components.process.nf.substitute_cancel.StoreProcSubstituteCancelNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;

final class S3StoreProcSubstituteCancelNfe extends StoreProcSubstituteCancelNfe {
    @Override
    public NfceSubstituteCancelStorage getStorage() {
        return StorageFactory.s3().getNfceStorage();
    }
}
