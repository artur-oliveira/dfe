package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteReceptionGtveStorage {

    void storeGtve(Store<br.inf.portalfiscal.cte.send.TGTVe> o) throws StorageException;

    void storeReturnGtve(Store<br.inf.portalfiscal.cte.send.TRetGTVe> o) throws StorageException;

    void storeProcGtve(Store<br.inf.portalfiscal.cte.send.TGTVeProc> o) throws StorageException;

}
