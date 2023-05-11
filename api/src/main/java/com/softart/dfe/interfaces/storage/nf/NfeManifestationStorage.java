package com.softart.dfe.interfaces.storage.nf;

import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TProcEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfeManifestationStorage extends Storage {
    /**
     * It stores a manifestation of a process event.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeProcManifestation(Store<TProcEvento> o) throws StorageException;

    /**
     * It stores the return manifestation of the event.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeRetManifestation(Store<TRetEnvEvento> o) throws StorageException;

    /**
     * It stores the manifestation of the event.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeSendManifestation(Store<TEnvEvento> o) throws StorageException;

}
