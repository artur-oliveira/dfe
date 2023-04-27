package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteReceptionSyncStorage {

    /**
     * It stores a CTe in the database.
     *
     * @param o The object to be stored.
     */
    void storeCteSync(Store<br.inf.portalfiscal.cte.send.TCTe> o) throws StorageException;

    /**
     * It stores the return of the CTe in the database.
     *
     * @param o The object to be stored.
     */
    void storeReturnCteSync(Store<br.inf.portalfiscal.cte.send.TRetCTe> o) throws StorageException;

    /**
     * It stores the CTe in the database.
     *
     * @param o The object to be stored.
     */
    void storeProcCteSync(Store<br.inf.portalfiscal.cte.send.TCteProc> o) throws StorageException;

}
