package org.dfe.interfaces.storage.cte4;

import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Store;

public interface CteEventStorage {

    /**
     * It stores an event.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeEvent(Store<br.inf.portalfiscal.cte.send400.TEvento> o) throws StorageException;

    /**
     * It stores the return event.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnEvent(Store<br.inf.portalfiscal.cte.send400.TRetEvento> o) throws StorageException;

    /**
     * It stores the object of type TProcEvento in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeProcEvent(Store<br.inf.portalfiscal.cte.send400.TProcEvento> o) throws StorageException;

}
