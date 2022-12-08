package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteReceptionStorage {

    void storeCte(Store<br.inf.portalfiscal.cte.send.TEnviCTe> o) throws StorageException;

    void storeReturnCte(Store<br.inf.portalfiscal.cte.send.TRetEnviCTe> o) throws StorageException;

    void storeProcCte(Store<br.inf.portalfiscal.cte.send.TCteProc> o) throws StorageException;

}
