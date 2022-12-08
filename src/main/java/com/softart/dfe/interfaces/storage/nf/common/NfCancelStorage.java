package com.softart.dfe.interfaces.storage.nf.common;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_cancel.TProcEvento;
import br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfCancelStorage extends Storage {
    void storeProcCancel(Store<TProcEvento> o) throws StorageException;

    void storeRetCancel(Store<TRetEnvEvento> o) throws StorageException;

    void storeSendCancel(Store<TEnvEvento> o) throws StorageException;

}
