package org.dfe.interfaces.storage.cte4;

import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Store;

public interface CteReceptionGtveStorage {

    /**
     * It stores the object of type br.inf.portalfiscal.cte.send400.TGTVe in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeGtve(Store<br.inf.portalfiscal.cte.send400.TGTVe> o) throws StorageException;

    /**
     * It stores the TRetGTVe object in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnGtve(Store<br.inf.portalfiscal.cte.send400.TRetGTVe> o) throws StorageException;

    /**
     * It stores the object of type br.inf.portalfiscal.cte.send400.TGTVeProc in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeProcGtve(Store<br.inf.portalfiscal.cte.send400.TGTVeProc> o) throws StorageException;

}
