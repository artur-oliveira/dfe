package com.softart.dfe.components.process.nf.correction_letter.impl.nostore;

import com.softart.dfe.components.process.nf.correction_letter.StoreRetCorrectionLetterNfe;
import com.softart.dfe.components.storage.StorageFactory;
import com.softart.dfe.interfaces.storage.nf.NfeCorrectionLetterStorage;

final class NoStoreRetCorrectionLetterNfe extends StoreRetCorrectionLetterNfe {
    @Override
    public NfeCorrectionLetterStorage getStorage() {
        return StorageFactory.noStorage().getNfeStorage();
    }
}
