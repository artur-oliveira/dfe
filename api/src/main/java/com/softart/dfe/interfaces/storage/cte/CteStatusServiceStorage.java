package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteStatusServiceStorage {

    /**
     * It stores the status of the service.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeStatusService(Store<br.inf.portalfiscal.cte.send.TConsStatServ> o) throws StorageException;

    /**
     * It stores the return status service.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnStatusService(Store<br.inf.portalfiscal.cte.send.TRetConsStatServ> o) throws StorageException;

}
