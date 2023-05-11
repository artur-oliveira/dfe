package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteInutilizationStorage {

    /**
     * It stores the object of type TInutCTe in the store.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeInutilization(Store<br.inf.portalfiscal.cte.send.TInutCTe> o) throws StorageException;

    /**
     * It stores the return of the inutilization of the CTe in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnInutilization(Store<br.inf.portalfiscal.cte.send.TRetInutCTe> o) throws StorageException;

    /**
     * It stores the object of type TProcInutCTe in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeProcInutilization(Store<br.inf.portalfiscal.cte.send.TProcInutCTe> o) throws StorageException;

}
