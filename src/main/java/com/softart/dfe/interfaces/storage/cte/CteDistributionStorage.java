package com.softart.dfe.interfaces.storage.cte;

import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Store;

public interface CteDistributionStorage {

    void storeDistribution(Store<br.inf.portalfiscal.cte.distribution.DistDFeInt> o) throws StorageException;

    void storeReturnDistribution(Store<br.inf.portalfiscal.cte.distribution.RetDistDFeInt> o) throws StorageException;
}
