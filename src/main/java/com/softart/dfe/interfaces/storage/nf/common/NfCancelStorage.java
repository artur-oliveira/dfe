package com.softart.dfe.interfaces.storage.nf.common;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_cancel.TProcEvento;
import br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfCancelStorage extends Storage {
    /**
     * It cancels a stored procedure.
     *
     * @param o The store object
     */
    void storeProcCancel(Store<TProcEvento> o) throws StorageException;

    /**
     * It stores the return value of the function.
     *
     * @param o The object to be stored.
     */
    void storeRetCancel(Store<TRetEnvEvento> o) throws StorageException;

    /**
     * It cancels the sending of an event.
     *
     * @param o The object to be stored.
     */
    void storeSendCancel(Store<TEnvEvento> o) throws StorageException;

}
