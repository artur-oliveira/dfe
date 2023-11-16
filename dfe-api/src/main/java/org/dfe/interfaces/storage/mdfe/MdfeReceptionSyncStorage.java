package org.dfe.interfaces.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.TMDFe;
import br.inf.portalfiscal.mdfe.classes.TMdfeProc;
import br.inf.portalfiscal.mdfe.classes.TRetMDFe;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Storage;
import org.dfe.interfaces.storage.Store;

public interface MdfeReceptionSyncStorage extends Storage {

    /**
     * It stores a MDFe
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeMdfe(Store<TMDFe> o) throws StorageException;

    /**
     * It stores the return of the MDFe in the database.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnMdfe(Store<TRetMDFe> o) throws StorageException;

    /**
     * This function will store the object `o` in the database
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeProcMdfeSync(Store<TMdfeProc> o) throws StorageException;

}
