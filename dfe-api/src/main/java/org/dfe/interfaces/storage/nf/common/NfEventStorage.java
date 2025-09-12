package org.dfe.interfaces.storage.nf.common;

import br.inf.portalfiscal.nfe.event_generic.TEnvEvento;
import br.inf.portalfiscal.nfe.event_generic.TProcEvento;
import br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Storage;
import org.dfe.interfaces.storage.Store;

public interface NfEventStorage extends Storage {
    /**
     * It cancels a stored procedure.
     *
     * @param o The store object
     * @throws StorageException StorageException
     */
    void storeProcEvent(Store<TProcEvento> o) throws StorageException;

    /**
     * It stores the return value of the function.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeRetEvent(Store<TRetEnvEvento> o) throws StorageException;

    /**
     * It cancels the sending of an event.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeSendEvent(Store<TEnvEvento> o) throws StorageException;

}
