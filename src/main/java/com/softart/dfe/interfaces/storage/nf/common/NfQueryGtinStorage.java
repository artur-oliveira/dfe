package com.softart.dfe.interfaces.storage.nf.common;

import br.inf.portalfiscal.nfe.gtin.TConsGTIN;
import br.inf.portalfiscal.nfe.gtin.TRetConsGTIN;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfQueryGtinStorage extends Storage {

    void storeReturnQueryGtin(Store<TRetConsGTIN> o) throws StorageException;

    void storeQueryGtin(Store<TConsGTIN> o) throws StorageException;
}
