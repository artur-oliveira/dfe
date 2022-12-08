package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteEventStorage {

    void storeEvent(Store<br.inf.portalfiscal.cte.send.TEvento> o) throws StorageException;

    void storeReturnEvent(Store<br.inf.portalfiscal.cte.send.TRetEvento> o) throws StorageException;

    void storeProcEvent(Store<br.inf.portalfiscal.cte.send.TProcEvento> o) throws StorageException;

}
