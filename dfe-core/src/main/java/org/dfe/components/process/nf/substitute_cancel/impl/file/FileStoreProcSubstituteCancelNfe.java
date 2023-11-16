package org.dfe.components.process.nf.substitute_cancel.impl.file;

import org.dfe.components.process.nf.substitute_cancel.StoreProcSubstituteCancelNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;

final class FileStoreProcSubstituteCancelNfe extends StoreProcSubstituteCancelNfe {
    @Override
    public NfceSubstituteCancelStorage getStorage() {
        return StorageFactory.fileSystem().getNfceStorage();
    }
}
