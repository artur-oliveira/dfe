package com.softart.dfe.interfaces.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsMDFeNaoEnc;
import br.inf.portalfiscal.mdfe.classes.TRetConsMDFeNaoEnc;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface MdfeQueryUnclosedStorage extends Storage {

    void storeRetQueryUnclosed(Store<TRetConsMDFeNaoEnc> o) throws StorageException;

    void storeSendQueryUnclosed(Store<TConsMDFeNaoEnc> o) throws StorageException;

}
