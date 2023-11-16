package org.dfe.interfaces.storage.cte;

import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Store;

public interface CteDistributionStorage {

    /**
     * It stores a distribution object.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeDistribution(Store<br.inf.portalfiscal.cte.distribution.DistDFeInt> o) throws StorageException;

    /**
     * It stores the return distribution of the CTe.
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeReturnDistribution(Store<br.inf.portalfiscal.cte.distribution.RetDistDFeInt> o) throws StorageException;
}
