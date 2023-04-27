package com.softart.dfe.components.process.nf.substitute_cancel.impl.nostore;

import com.softart.dfe.components.process.nf.substitute_cancel.StoreSendSubstituteCancelNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;

final class NoStoreSubstituteCancelNfe extends StoreSendSubstituteCancelNfe {
    @Override
    public NfceSubstituteCancelStorage getStorage() {
        return StorageFactory.noStorage().getNfceStorage();
    }
}
