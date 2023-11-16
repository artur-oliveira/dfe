package org.dfe.interfaces.storage.cte;

import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Store;

public interface CteQueryReceiptStorage {

    /**
     * Store the query receipt for the given CTe
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeQueryReceipt(Store<br.inf.portalfiscal.cte.send.TConsReciCTe> o) throws StorageException;

    /**
     * It stores the return query receipt.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnQueryReceipt(Store<br.inf.portalfiscal.cte.send.TRetConsReciCTe> o) throws StorageException;

}
