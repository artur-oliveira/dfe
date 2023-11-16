package org.dfe.components.process.nf.substitute_cancel.impl.nostore;

import org.dfe.components.process.nf.substitute_cancel.StoreReturnSubstituteCancelNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;

final class NoStoreReturnSubstituteCancelNfe extends StoreReturnSubstituteCancelNfe {
    @Override
    public NfceSubstituteCancelStorage getStorage() {
        return StorageFactory.noStorage().getNfceStorage();
    }
}
