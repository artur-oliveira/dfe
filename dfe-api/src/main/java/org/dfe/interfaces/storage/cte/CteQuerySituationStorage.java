package org.dfe.interfaces.storage.cte;

import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Store;

public interface CteQuerySituationStorage {

    /**
     * It stores the query situation of the CTe.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeQuerySituation(Store<br.inf.portalfiscal.cte.send.TConsSitCTe> o) throws StorageException;

    /**
     * It stores the return of the query situation of the CTe.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnQuerySituation(Store<br.inf.portalfiscal.cte.send.TRetConsSitCTe> o) throws StorageException;

}