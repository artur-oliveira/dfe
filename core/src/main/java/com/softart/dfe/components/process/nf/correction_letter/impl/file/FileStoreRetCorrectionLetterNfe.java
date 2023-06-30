package com.softart.dfe.components.process.nf.correction_letter.impl.file;

import com.softart.dfe.components.process.nf.correction_letter.StoreRetCorrectionLetterNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeCorrectionLetterStorage;

final class FileStoreRetCorrectionLetterNfe extends StoreRetCorrectionLetterNfe {
    @Override
    public NfeCorrectionLetterStorage getStorage() {
        return StorageFactory.fileSystem().getNfeStorage();
    }
}
