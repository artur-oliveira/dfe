package com.softart.dfe.interfaces.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.TEnviMDFe;
import br.inf.portalfiscal.mdfe.classes.TMdfeProc;
import br.inf.portalfiscal.mdfe.classes.TRetEnviMDFe;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface MdfeReceptionStorage extends Storage {

    void storeSendMdfe(Store<TEnviMDFe> o) throws StorageException;

    void storeReturnSendMdfe(Store<TRetEnviMDFe> o) throws StorageException;

    void storeProcMdfe(Store<TMdfeProc> o) throws StorageException;

}
