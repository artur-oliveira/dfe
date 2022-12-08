package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteStatusServiceStorage {

    void storeStatusService(Store<br.inf.portalfiscal.cte.send.TConsStatServ> o) throws StorageException;

    void storeReturnStatusService(Store<br.inf.portalfiscal.cte.send.TRetConsStatServ> o) throws StorageException;

}
