package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteReceptionSyncStorage {

    void storeCteSync(Store<br.inf.portalfiscal.cte.send.TCTe> o) throws StorageException;

    void storeReturnCteSync(Store<br.inf.portalfiscal.cte.send.TRetCTe> o) throws StorageException;

    void storeProcCteSync(Store<br.inf.portalfiscal.cte.send.TCteProc> o) throws StorageException;

}
