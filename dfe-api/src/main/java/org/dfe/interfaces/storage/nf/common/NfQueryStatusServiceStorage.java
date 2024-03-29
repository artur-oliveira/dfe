package org.dfe.interfaces.storage.nf.common;

import br.inf.portalfiscal.nfe.send.TConsStatServ;
import br.inf.portalfiscal.nfe.send.TRetConsStatServ;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Storage;
import org.dfe.interfaces.storage.Store;

public interface NfQueryStatusServiceStorage extends Storage {
    /**
     * Stores the given object in the database
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeSendQueryStatusService(Store<TConsStatServ> o) throws StorageException;

    /**
     * It stores the return query status service.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnQueryStatusService(Store<TRetConsStatServ> o) throws StorageException;
}
