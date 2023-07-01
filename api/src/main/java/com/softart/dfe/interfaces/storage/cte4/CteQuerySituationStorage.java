package com.softart.dfe.interfaces.storage.cte4;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteQuerySituationStorage {

    /**
     * It stores the query situation of the CTe.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeQuerySituation(Store<br.inf.portalfiscal.cte.send400.TConsSitCTe> o) throws StorageException;

    /**
     * It stores the return of the query situation of the CTe.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnQuerySituation(Store<br.inf.portalfiscal.cte.send400.TRetConsSitCTe> o) throws StorageException;

}
