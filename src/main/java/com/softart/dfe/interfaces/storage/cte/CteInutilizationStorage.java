package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteInutilizationStorage {

    void storeInutilization(Store<br.inf.portalfiscal.cte.send.TInutCTe> o) throws StorageException;

    void storeReturnInutilization(Store<br.inf.portalfiscal.cte.send.TRetInutCTe> o) throws StorageException;

    void storeProcInutilization(Store<br.inf.portalfiscal.cte.send.TProcInutCTe> o) throws StorageException;

}
