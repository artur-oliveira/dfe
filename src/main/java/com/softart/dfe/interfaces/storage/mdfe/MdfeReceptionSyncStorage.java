package com.softart.dfe.interfaces.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.TMDFe;
import br.inf.portalfiscal.mdfe.classes.TMdfeProc;
import br.inf.portalfiscal.mdfe.classes.TRetMDFe;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface MdfeReceptionSyncStorage extends Storage {

    void storeMdfe(Store<TMDFe> o) throws StorageException;

    void storeReturnMdfe(Store<TRetMDFe> o) throws StorageException;

    void storeProcMdfeSync(Store<TMdfeProc> o) throws StorageException;

}
