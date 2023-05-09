package com.softart.dfe.interfaces.storage.nf.common;

import br.inf.portalfiscal.nfe.send.TConsStatServ;
import br.inf.portalfiscal.nfe.send.TRetConsStatServ;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfQueryStatusServiceStorage extends Storage {
    /**
     * Stores the given object in the database
     *
     * @param o The object to be stored.
     */
    void storeSendQueryStatusService(Store<TConsStatServ> o) throws StorageException;

    /**
     * It stores the return query status service.
     *
     * @param o The object to be stored.
     */
    void storeReturnQueryStatusService(Store<TRetConsStatServ> o) throws StorageException;
}
