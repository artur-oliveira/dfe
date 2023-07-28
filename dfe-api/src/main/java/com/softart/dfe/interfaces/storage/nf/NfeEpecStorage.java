package com.softart.dfe.interfaces.storage.nf;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import br.inf.portalfiscal.nfe.event_epec.TProcEvento;
import br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfeEpecStorage extends Storage {

    /**
     * It stores a TProcEvento object in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeProcEpec(Store<TProcEvento> o) throws StorageException;

    /**
     * It stores the return value of the function in the store.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeRetEpec(Store<TRetEnvEvento> o) throws StorageException;

    /**
     * It stores an event in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeSendEpec(Store<TEnvEvento> o) throws StorageException;

}
