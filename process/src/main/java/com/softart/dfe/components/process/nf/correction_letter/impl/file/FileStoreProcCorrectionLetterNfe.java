package com.softart.dfe.components.process.nf.correction_letter.impl.file;

import com.softart.dfe.components.process.nf.correction_letter.StoreProcCorrectionLetterNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeCorrectionLetterStorage;

final class FileStoreProcCorrectionLetterNfe extends StoreProcCorrectionLetterNfe {
    @Override
    public NfeCorrectionLetterStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
