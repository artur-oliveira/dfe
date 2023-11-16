package org.dfe.components.process.nf.correction_letter.impl.s3;

import org.dfe.components.process.nf.correction_letter.StoreSendCorrectionLetterNfe;
import org.dfe.components.storage.StorageFactory;
import org.dfe.interfaces.storage.nf.NfeCorrectionLetterStorage;

final class S3StoreSendCorrectionLetterNfe extends StoreSendCorrectionLetterNfe {
    @Override
    public NfeCorrectionLetterStorage getStorage() {
        return StorageFactory.s3().getNfeStorage();
    }
}
