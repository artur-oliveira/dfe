package com.softart.dfe.components.process.nf.substitute_cancel.impl.nostore;

import com.softart.dfe.components.process.nf.substitute_cancel.StoreReturnSubstituteCancelNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;

final class NoStoreReturnSubstituteCancelNfe extends StoreReturnSubstituteCancelNfe {
    @Override
    public NfceSubstituteCancelStorage getStorage() {
        return StorageFactory.noStorage().getNfceStorage();
    }
}
