package org.dfe.components.process.nf.substitute_cancel.impl.file;

import org.dfe.components.process.nf.substitute_cancel.StoreReturnSubstituteCancelNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;

final class FileStoreReturnSubstituteCancelNfe extends StoreReturnSubstituteCancelNfe {
    @Override
    public NfceSubstituteCancelStorage getStorage() {
        return StorageFactory.fileSystem().getNfceStorage();
    }
}
