package com.softart.dfe.components.process.nf.substitute_cancel.impl.file;

import com.softart.dfe.components.process.nf.substitute_cancel.StoreProcSubstituteCancelNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;

final class FileStoreProcSubstituteCancelNfe extends StoreProcSubstituteCancelNfe {
    @Override
    public NfceSubstituteCancelStorage getStorage() {
        return StorageFactory.fileSystem().getNfceStorage();
    }
}
