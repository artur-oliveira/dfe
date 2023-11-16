package org.dfe.components.process.nf.correction_letter.impl.file;

import org.dfe.components.process.nf.correction_letter.StoreSendCorrectionLetterNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeCorrectionLetterStorage;

final class FileStoreSendCorrectionLetterNfe extends StoreSendCorrectionLetterNfe {
    @Override
    public NfeCorrectionLetterStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
