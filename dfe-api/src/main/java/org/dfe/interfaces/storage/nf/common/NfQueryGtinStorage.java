package org.dfe.interfaces.storage.nf.common;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Storage;
import org.dfe.interfaces.storage.Store;

public interface NfQueryGtinStorage extends Storage {

    /**
     * Stores the return query GTIN
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnQueryGtin(Store<TRetConsGTIN> o) throws StorageException;

    /**
     * Store a GTIN in the database
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeQueryGtin(Store<TConsGTIN> o) throws StorageException;
}
