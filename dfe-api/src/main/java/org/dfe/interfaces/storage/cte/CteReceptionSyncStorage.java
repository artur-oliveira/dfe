package org.dfe.interfaces.storage.cte;

import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Store;

public interface CteReceptionSyncStorage {

    /**
     * It stores a CTe in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeCteSync(Store<br.inf.portalfiscal.cte.send.TCTe> o) throws StorageException;

    /**
     * It stores the return of the CTe in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnCteSync(Store<br.inf.portalfiscal.cte.send.TRetCTe> o) throws StorageException;

    /**
     * It stores the CTe in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeProcCteSync(Store<br.inf.portalfiscal.cte.send.TCteProc> o) throws StorageException;

}
