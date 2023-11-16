package org.dfe.interfaces.storage.mdfe;

import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Store;

public interface MdfeStatusServiceStorage {

    /**
     * It stores the status of the MDFe service.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeStatusService(Store<br.inf.portalfiscal.mdfe.classes.TConsStatServ> o) throws StorageException;

    /**
     * It stores the return status service.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnStatusService(Store<br.inf.portalfiscal.mdfe.classes.TRetConsStatServ> o) throws StorageException;

}
