package org.dfe.components.process.nf.substitute_cancel.impl.nostore;

import org.dfe.components.process.nf.substitute_cancel.StoreSendSubstituteCancelNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;

final class NoStoreSubstituteCancelNfe extends StoreSendSubstituteCancelNfe {
    @Override
    public NfceSubstituteCancelStorage getStorage() {
        return StorageFactory.noStorage().getNfceStorage();
    }
}
