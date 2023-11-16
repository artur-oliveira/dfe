package org.dfe.interfaces.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsMDFeNaoEnc;
import br.inf.portalfiscal.mdfe.classes.TRetConsMDFeNaoEnc;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Storage;
import org.dfe.interfaces.storage.Store;

public interface MdfeQueryUnclosedStorage extends Storage {

    /**
     * It stores a TRetConsMDFeNaoEnc object in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeRetQueryUnclosed(Store<TRetConsMDFeNaoEnc> o) throws StorageException;

    /**
     * It stores a TConsMDFeNaoEnc object in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeSendQueryUnclosed(Store<TConsMDFeNaoEnc> o) throws StorageException;

}
