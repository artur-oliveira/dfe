package com.softart.dfe.interfaces.storage.nf;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfceSubstituteCancelStorage extends Storage {

    void storeProcSubstituteCancel(Store<TProcEvento> o) throws StorageException;

    void storeReturnSubstituteCancel(Store<TRetEnvEvento> o) throws StorageException;

    void storeSendSubstituteCancel(Store<TEnvEvento> o) throws StorageException;

}
