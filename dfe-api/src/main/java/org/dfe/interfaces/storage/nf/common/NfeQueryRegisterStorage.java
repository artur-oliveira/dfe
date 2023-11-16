package org.dfe.interfaces.storage.nf.common;

import br.inf.portalfiscal.nfe.send.TConsCad;
import br.inf.portalfiscal.nfe.send.TRetConsCad;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Storage;
import org.dfe.interfaces.storage.Store;

public interface NfeQueryRegisterStorage extends Storage {
    /**
     * Stores the given object in the database
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeSendQueryRegister(Store<TConsCad> o) throws StorageException;

    /**
     * It stores the return query status service.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnQueryRegister(Store<TRetConsCad> o) throws StorageException;
}
