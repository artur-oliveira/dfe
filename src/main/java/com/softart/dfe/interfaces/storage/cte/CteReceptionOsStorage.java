package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteReceptionOsStorage {

    void storeCteOs(Store<br.inf.portalfiscal.cte.send.TCTeOS> o) throws StorageException;

    void storeReturnCteOs(Store<br.inf.portalfiscal.cte.send.TRetCTeOS> o) throws StorageException;

    void storeProcCteOs(Store<br.inf.portalfiscal.cte.send.TCteOSProc> o) throws StorageException;

}
