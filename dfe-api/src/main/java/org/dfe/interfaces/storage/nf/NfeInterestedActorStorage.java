package org.dfe.interfaces.storage.nf;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Storage;
import org.dfe.interfaces.storage.Store;

public interface NfeInterestedActorStorage extends Storage {

    /**
     * It stores the interested actor in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeProcInterestedActor(Store<TProcEvento> o) throws StorageException;

    /**
     * It stores the interested actor in the store.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeRetInterestedActor(Store<TRetEnvEvento> o) throws StorageException;

    /**
     * It stores the interested actor in the store.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeSendInterestedActor(Store<TEnvEvento> o) throws StorageException;

}
