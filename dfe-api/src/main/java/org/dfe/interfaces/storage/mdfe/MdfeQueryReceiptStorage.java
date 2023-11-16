package org.dfe.interfaces.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.TConsReciMDFe;
import br.inf.portalfiscal.mdfe.classes.TRetConsReciMDFe;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Storage;
import org.dfe.interfaces.storage.Store;

public interface MdfeQueryReceiptStorage extends Storage {

    /**
     * It stores the return of the query of the receipt of the MDFe.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeRetQueryReceipt(Store<TRetConsReciMDFe> o) throws StorageException;

    /**
     * It stores the receipt of the query of the MDFe.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeSendQueryReceipt(Store<TConsReciMDFe> o) throws StorageException;

}
