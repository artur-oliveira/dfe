package com.softart.dfe.interfaces.storage.mdfe;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface MdfeStatusServiceStorage {

    void storeStatusService(Store<br.inf.portalfiscal.mdfe.classes.TConsStatServ> o) throws StorageException;

    void storeReturnStatusService(Store<br.inf.portalfiscal.mdfe.classes.TRetConsStatServ> o) throws StorageException;

}
