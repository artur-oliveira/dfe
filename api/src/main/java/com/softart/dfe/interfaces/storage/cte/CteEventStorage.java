package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteEventStorage {

    /**
     * It stores an event.
     *
     * @param o The object to be stored.
     */
    void storeEvent(Store<br.inf.portalfiscal.cte.send.TEvento> o) throws StorageException;

    /**
     * It stores the return event.
     *
     * @param o The object to be stored.
     */
    void storeReturnEvent(Store<br.inf.portalfiscal.cte.send.TRetEvento> o) throws StorageException;

    /**
     * It stores the object of type TProcEvento in the database.
     *
     * @param o The object to be stored.
     */
    void storeProcEvent(Store<br.inf.portalfiscal.cte.send.TProcEvento> o) throws StorageException;

}
