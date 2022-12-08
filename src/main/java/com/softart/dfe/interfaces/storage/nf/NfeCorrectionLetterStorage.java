package com.softart.dfe.interfaces.storage.nf;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento;
import br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfeCorrectionLetterStorage extends Storage {

    void storeProcCorrectionLetter(Store<TProcEvento> o) throws StorageException;

    void storeRetCorrectionLetter(Store<TRetEnvEvento> o) throws StorageException;

    void storeSendCorrectionLetter(Store<TEnvEvento> o) throws StorageException;

}
