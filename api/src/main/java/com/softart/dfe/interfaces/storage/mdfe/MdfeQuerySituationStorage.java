package com.softart.dfe.interfaces.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetConsSitMDFe;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface MdfeQuerySituationStorage extends Storage {

    /**
     * It stores the return of the query situation of the MDFe.
     *
     * @param o The object to be stored.
     */
    void storeRetQuerySituation(Store<TRetConsSitMDFe> o) throws StorageException;

    /**
     * It stores the query situation of the MDFe.
     *
     * @param o The object to be stored.
     */
    void storeSendQuerySituation(Store<TConsSitMDFe> o) throws StorageException;

}
