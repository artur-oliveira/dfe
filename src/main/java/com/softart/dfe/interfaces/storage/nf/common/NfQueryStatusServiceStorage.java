package com.softart.dfe.interfaces.storage.nf.common;

import br.inf.portalfiscal.nfe.send.TConsStatServ;
import br.inf.portalfiscal.nfe.send.TRetConsStatServ;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfQueryStatusServiceStorage extends Storage {
    void storeSendQueryStatusService(Store<TConsStatServ> o) throws StorageException;

    void storeReturnQueryStatusService(Store<TRetConsStatServ> o) throws StorageException;
}
