package org.dfe.components.process.nf.substitute_cancel.impl.s3;

import org.dfe.components.process.nf.substitute_cancel.StoreReturnSubstituteCancelNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;

final class S3StoreReturnSubstituteCancelNfe extends StoreReturnSubstituteCancelNfe {
    @Override
    public NfceSubstituteCancelStorage getStorage() {
        return StorageFactory.s3().getNfceStorage();
    }
}
