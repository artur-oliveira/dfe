package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteReceptionGtveStorage {

    /**
     * It stores the object of type br.inf.portalfiscal.cte.send.TGTVe in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeGtve(Store<br.inf.portalfiscal.cte.send.TGTVe> o) throws StorageException;

    /**
     * It stores the TRetGTVe object in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnGtve(Store<br.inf.portalfiscal.cte.send.TRetGTVe> o) throws StorageException;

    /**
     * It stores the object of type br.inf.portalfiscal.cte.send.TGTVeProc in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeProcGtve(Store<br.inf.portalfiscal.cte.send.TGTVeProc> o) throws StorageException;

}
