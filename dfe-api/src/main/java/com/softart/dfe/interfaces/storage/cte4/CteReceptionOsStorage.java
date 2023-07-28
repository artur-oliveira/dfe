package com.softart.dfe.interfaces.storage.cte4;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteReceptionOsStorage {

    /**
     * It stores a CTeOS object in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeCteOs(Store<br.inf.portalfiscal.cte.send400.TCTeOS> o) throws StorageException;

    /**
     * It stores the return of the CTeOS operation.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnCteOs(Store<br.inf.portalfiscal.cte.send400.TRetCTeOS> o) throws StorageException;

    /**
     * It stores the object o in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeProcCteOs(Store<br.inf.portalfiscal.cte.send400.TCteOSProc> o) throws StorageException;

}
