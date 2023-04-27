package com.softart.dfe.interfaces.storage.nf.common;

import br.inf.portalfiscal.nfe.send.TConsSitNFe;
import br.inf.portalfiscal.nfe.send.TRetConsSitNFe;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfQueryProtocolStorage extends Storage {

    /**
     * It stores the return of the query protocol.
     *
     * @param o The object to be stored.
     */
    void storeRetQueryProtocol(Store<TRetConsSitNFe> o) throws StorageException;

    /**
     * It stores the environment query protocol.
     *
     * @param o The object to be stored.
     */
    void storeEnvQueryProtocol(Store<TConsSitNFe> o) throws StorageException;
}
