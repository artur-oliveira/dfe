package com.softart.dfe.interfaces.storage.nf;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfInutStorage extends Storage {

    /**
     * It stores the object of type TProcInutNFe in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeProcInut(Store<br.inf.portalfiscal.nfe.send.TProcInutNFe> o) throws StorageException;

    /**
     * It stores the TRetInutNFe object in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeRetInut(Store<br.inf.portalfiscal.nfe.send.TRetInutNFe> o) throws StorageException;

    /**
     * It stores the TInutNFe object in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeEnvInut(Store<br.inf.portalfiscal.nfe.send.TInutNFe> o) throws StorageException;
}
