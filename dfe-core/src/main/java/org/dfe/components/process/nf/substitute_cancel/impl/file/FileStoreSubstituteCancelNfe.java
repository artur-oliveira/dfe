package org.dfe.components.process.nf.substitute_cancel.impl.file;

import org.dfe.components.process.nf.substitute_cancel.StoreSendSubstituteCancelNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;

final class FileStoreSubstituteCancelNfe extends StoreSendSubstituteCancelNfe {
    @Override
    public NfceSubstituteCancelStorage getStorage() {
        return StorageFactory.fileSystem().getNfceStorage();
    }
}
