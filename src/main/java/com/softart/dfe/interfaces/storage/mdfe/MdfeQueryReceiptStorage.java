package com.softart.dfe.interfaces.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsReciMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetConsReciMDFe;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface MdfeQueryReceiptStorage extends Storage {

    void storeRetQueryReceipt(Store<TRetConsReciMDFe> o) throws StorageException;

    void storeSendQueryReceipt(Store<TConsReciMDFe> o) throws StorageException;

}
