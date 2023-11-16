package org.dfe.components.process.nf.substitute_cancel.impl.nostore;

import org.dfe.components.process.nf.substitute_cancel.StoreProcSubstituteCancelNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;

final class NoStoreProcSubstituteCancelNfe extends StoreProcSubstituteCancelNfe {
    @Override
    public NfceSubstituteCancelStorage getStorage() {
        return StorageFactory.noStorage().getNfceStorage();
    }
}
