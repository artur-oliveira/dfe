package org.dfe.components.process.nf.substitute_cancel.impl.s3;

import org.dfe.components.process.nf.substitute_cancel.StoreSendSubstituteCancelNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;

final class S3StoreSubstituteCancelNfe extends StoreSendSubstituteCancelNfe {
    @Override
    public NfceSubstituteCancelStorage getStorage() {
        return StorageFactory.s3().getNfceStorage();
    }
}
