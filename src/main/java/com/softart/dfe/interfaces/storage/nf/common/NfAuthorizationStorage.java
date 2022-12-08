package com.softart.dfe.interfaces.storage.nf.common;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import br.inf.portalfiscal.nfe.send.TNfeProc;
import br.inf.portalfiscal.nfe.send.TRetEnviNFe;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfAuthorizationStorage extends Storage {
    void storeProcNfe(Store<TNfeProc> o) throws StorageException;

    void storeRetNfe(Store<TRetEnviNFe> o) throws StorageException;

    void storeEnvNfe(Store<TEnviNFe> o) throws StorageException;

}
