package com.softart.dfe.components.process.nf.correction_letter.impl.s3;

import com.softart.dfe.components.process.nf.correction_letter.StoreProcCorrectionLetterNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeCorrectionLetterStorage;

final class S3StoreProcCorrectionLetterNfe extends StoreProcCorrectionLetterNfe {
    @Override
    public NfeCorrectionLetterStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
