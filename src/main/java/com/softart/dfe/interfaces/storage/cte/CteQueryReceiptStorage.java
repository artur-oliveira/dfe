package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteQueryReceiptStorage {

    void storeQueryReceipt(Store<br.inf.portalfiscal.cte.send.TConsReciCTe> o) throws StorageException;

    void storeReturnQueryReceipt(Store<br.inf.portalfiscal.cte.send.TRetConsReciCTe> o) throws StorageException;

}
