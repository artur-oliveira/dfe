package org.dfe.interfaces.storage.nf.common;

import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Storage;
import org.dfe.interfaces.storage.Store;

public interface NfReturnAuthorizationStorage extends Storage {

    /**
     * It stores the return authorization in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeRetReturnAuthorization(Store<br.inf.portalfiscal.nfe.send.TRetConsReciNFe> o) throws StorageException;

    /**
     * It stores the return authorization of the NFe.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeEnvReturnAuthorization(Store<br.inf.portalfiscal.nfe.send.TConsReciNFe> o) throws StorageException;
}
