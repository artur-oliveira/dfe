package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteQuerySituationStorage {

    void storeQuerySituation(Store<br.inf.portalfiscal.cte.send.TConsSitCTe> o) throws StorageException;

    void storeReturnQuerySituation(Store<br.inf.portalfiscal.cte.send.TRetConsSitCTe> o) throws StorageException;

}
