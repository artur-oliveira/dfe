package org.dfe.interfaces.storage.cte4;

import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Store;

public interface CteStatusServiceStorage {

    /**
     * It stores the status of the service.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeStatusService(Store<br.inf.portalfiscal.cte.send400.TConsStatServ> o) throws StorageException;

    /**
     * It stores the return status service.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnStatusService(Store<br.inf.portalfiscal.cte.send400.TRetConsStatServ> o) throws StorageException;

}
