package com.softart.dfe.components.process.nf.substitute_cancel.impl.s3;

import com.softart.dfe.components.process.nf.substitute_cancel.StoreSendSubstituteCancelNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;

final class S3StoreSubstituteCancelNfe extends StoreSendSubstituteCancelNfe {
    @Override
    public NfceSubstituteCancelStorage getStorage() {
        return StorageFactory.s3().getNfceStorage();
    }
}
