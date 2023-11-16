package org.dfe.interfaces.storage.nf;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Storage;
import org.dfe.interfaces.storage.Store;

public interface NfceSubstituteCancelStorage extends Storage {

    /**
     * It cancels the substitution of a procedure.
     *
     * @param o The store object
     * @throws StorageException StorageException
     */
    void storeProcSubstituteCancel(Store<TProcEvento> o) throws StorageException;

    /**
     * It stores a return substitute cancel event.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnSubstituteCancel(Store<TRetEnvEvento> o) throws StorageException;

    /**
     * It stores a substitute cancel event.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeSendSubstituteCancel(Store<TEnvEvento> o) throws StorageException;

}
