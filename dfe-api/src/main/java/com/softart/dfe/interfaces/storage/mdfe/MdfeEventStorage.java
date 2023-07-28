package com.softart.dfe.interfaces.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.TEvento;
import br.inf.portalfiscal.mdfe.classes.TProcEvento;
import br.inf.portalfiscal.mdfe.classes.TRetEvento;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface MdfeEventStorage extends Storage {

    /**
     * It stores a TRetEvento object in the Store object.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeRetEvent(Store<TRetEvento> o) throws StorageException;

    /**
     * Stores the event in the storage
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeSendEvent(Store<TEvento> o) throws StorageException;

    /**
     * It stores a TProcEvento object in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeProcEvent(Store<TProcEvento> o) throws StorageException;

}
