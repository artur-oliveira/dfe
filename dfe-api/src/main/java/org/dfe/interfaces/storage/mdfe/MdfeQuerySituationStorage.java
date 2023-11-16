package org.dfe.interfaces.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetConsSitMDFe;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Storage;
import org.dfe.interfaces.storage.Store;

public interface MdfeQuerySituationStorage extends Storage {

    /**
     * It stores the return of the query situation of the MDFe.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeRetQuerySituation(Store<TRetConsSitMDFe> o) throws StorageException;

    /**
     * It stores the query situation of the MDFe.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeSendQuerySituation(Store<TConsSitMDFe> o) throws StorageException;

}
