package org.dfe.interfaces.storage.cte;

import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Store;

public interface CteReceptionOsStorage {

    /**
     * It stores a CTeOS object in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeCteOs(Store<br.inf.portalfiscal.cte.send.TCTeOS> o) throws StorageException;

    /**
     * It stores the return of the CTeOS operation.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnCteOs(Store<br.inf.portalfiscal.cte.send.TRetCTeOS> o) throws StorageException;

    /**
     * It stores the object o in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeProcCteOs(Store<br.inf.portalfiscal.cte.send.TCteOSProc> o) throws StorageException;

}
