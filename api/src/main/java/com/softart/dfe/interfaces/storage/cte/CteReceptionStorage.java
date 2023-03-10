package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteReceptionStorage {

    /**
     * It stores the CTe in the database.
     *
     * @param o The object to be stored.
     */
    void storeCte(Store<br.inf.portalfiscal.cte.send.TEnviCTe> o) throws StorageException;

    /**
     * It stores the return of the CTe in the database.
     *
     * @param o The object to be stored.
     */
    void storeReturnCte(Store<br.inf.portalfiscal.cte.send.TRetEnviCTe> o) throws StorageException;

    /**
     * It stores a CTe in the database.
     *
     * @param o The object to be stored.
     */
    void storeProcCte(Store<br.inf.portalfiscal.cte.send.TCteProc> o) throws StorageException;

}
