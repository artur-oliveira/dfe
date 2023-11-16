package org.dfe.interfaces.storage.nf.common;

import br.inf.portalfiscal.nfe.send.TConsSitNFe;
import br.inf.portalfiscal.nfe.send.TRetConsSitNFe;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Storage;
import org.dfe.interfaces.storage.Store;

public interface NfQueryProtocolStorage extends Storage {

    /**
     * It stores the return of the query protocol.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeRetQueryProtocol(Store<TRetConsSitNFe> o) throws StorageException;

    /**
     * It stores the environment query protocol.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeEnvQueryProtocol(Store<TConsSitNFe> o) throws StorageException;
}
