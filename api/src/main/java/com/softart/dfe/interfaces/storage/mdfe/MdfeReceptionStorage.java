package com.softart.dfe.interfaces.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.TEnviMDFe;
import br.inf.portalfiscal.mdfe.classes.TMdfeProc;
import br.inf.portalfiscal.mdfe.classes.TRetEnviMDFe;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface MdfeReceptionStorage extends Storage {

    /**
     * > Stores the MDFe in the database
     *
     * @param o The object to be stored.
     */
    void storeSendMdfe(Store<TEnviMDFe> o) throws StorageException;

    /**
     * It stores the return of the MDFe sending.
     *
     * @param o The object to be stored.
     */
    void storeReturnSendMdfe(Store<TRetEnviMDFe> o) throws StorageException;

    /**
     * Store the MDF-e process in the database.
     *
     * @param o The object to be stored.
     */
    void storeProcMdfe(Store<TMdfeProc> o) throws StorageException;

}
