package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteDistributionStorage {

    /**
     * It stores a distribution object.
     *
     * @param o The object to be stored.
     */
    void storeDistribution(Store<br.inf.portalfiscal.cte.distribution.DistDFeInt> o) throws StorageException;

    /**
     * It stores the return distribution of the CTe.
     *
     * @param o The object to be stored.
     */
    void storeReturnDistribution(Store<br.inf.portalfiscal.cte.distribution.RetDistDFeInt> o) throws StorageException;
}
