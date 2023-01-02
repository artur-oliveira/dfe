package com.softart.dfe.components.process.nf.correction_letter.impl.nostore;

import com.softart.dfe.components.process.nf.correction_letter.StoreSendCorrectionLetterNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeCorrectionLetterStorage;

final class NoStoreCorrectionLetterNfe extends StoreSendCorrectionLetterNfe {
    @Override
    public NfeCorrectionLetterStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
