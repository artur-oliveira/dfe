package com.softart.dfe.interfaces.storage.nf;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfInutStorage extends Storage {

    void storeProcInut(Store<br.inf.portalfiscal.nfe.send.TProcInutNFe> o) throws StorageException;

    void storeRetInut(Store<br.inf.portalfiscal.nfe.send.TRetInutNFe> o) throws StorageException;

    void storeEnvInut(Store<br.inf.portalfiscal.nfe.send.TInutNFe> o) throws StorageException;
}
