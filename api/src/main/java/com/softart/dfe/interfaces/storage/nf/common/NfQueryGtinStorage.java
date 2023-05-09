package com.softart.dfe.interfaces.storage.nf.common;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfQueryGtinStorage extends Storage {

    /**
     * Stores the return query GTIN
     *
     * @param o The object to be stored.
     */
    void storeReturnQueryGtin(Store<TRetConsGTIN> o) throws StorageException;

    /**
     * Store a GTIN in the database
     *
     * @param o The object to be stored.
     */
    void storeQueryGtin(Store<TConsGTIN> o) throws StorageException;
}
