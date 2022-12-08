package com.softart.dfe.interfaces.storage.nf.common;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfReturnAuthorizationStorage extends Storage {

    void storeRetReturnAuthorization(Store<br.inf.portalfiscal.nfe.send.TRetConsReciNFe> o) throws StorageException;

    void storeEnvReturnAuthorization(Store<br.inf.portalfiscal.nfe.send.TConsReciNFe> o) throws StorageException;
}
