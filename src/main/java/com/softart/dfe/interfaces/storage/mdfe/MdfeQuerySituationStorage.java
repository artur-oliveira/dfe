package com.softart.dfe.interfaces.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsSitMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetConsSitMDFe;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface MdfeQuerySituationStorage extends Storage {

    void storeRetQuerySituation(Store<TRetConsSitMDFe> o) throws StorageException;

    void storeSendQuerySituation(Store<TConsSitMDFe> o) throws StorageException;

}
