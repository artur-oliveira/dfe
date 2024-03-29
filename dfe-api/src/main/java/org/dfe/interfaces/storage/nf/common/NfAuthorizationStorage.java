package org.dfe.interfaces.storage.nf.common;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import br.inf.portalfiscal.nfe.send.TNfeProc;
import br.inf.portalfiscal.nfe.send.TRetEnviNFe;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Storage;
import org.dfe.interfaces.storage.Store;

public interface NfAuthorizationStorage extends Storage {
    /**
     * Store a TNfeProc object in the database
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeProcNfe(Store<TNfeProc> o) throws StorageException;

    /**
     * It stores the return of the NFe.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeRetNfe(Store<TRetEnviNFe> o) throws StorageException;

    /**
     * It stores the TEnviNFe object in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeEnvNfe(Store<TEnviNFe> o) throws StorageException;

}
