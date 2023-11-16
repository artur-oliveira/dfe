package org.dfe.interfaces.storage.cte;

import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Store;

public interface CteReceptionStorage {

    /**
     * It stores the CTe in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeCte(Store<br.inf.portalfiscal.cte.send.TEnviCTe> o) throws StorageException;

    /**
     * It stores the return of the CTe in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnCte(Store<br.inf.portalfiscal.cte.send.TRetEnviCTe> o) throws StorageException;

    /**
     * It stores a CTe in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeProcCte(Store<br.inf.portalfiscal.cte.send.TCteProc> o) throws StorageException;

}
