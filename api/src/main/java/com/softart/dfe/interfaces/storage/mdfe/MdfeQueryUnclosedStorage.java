package com.softart.dfe.interfaces.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsMDFeNaoEnc;
import br.inf.portalfiscal.mdfe.classes.TRetConsMDFeNaoEnc;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface MdfeQueryUnclosedStorage extends Storage {

    /**
     * It stores a TRetConsMDFeNaoEnc object in the database.
     *
     * @param o The object to be stored.
     */
    void storeRetQueryUnclosed(Store<TRetConsMDFeNaoEnc> o) throws StorageException;

    /**
     * It stores a TConsMDFeNaoEnc object in the database.
     *
     * @param o The object to be stored.
     */
    void storeSendQueryUnclosed(Store<TConsMDFeNaoEnc> o) throws StorageException;

}
