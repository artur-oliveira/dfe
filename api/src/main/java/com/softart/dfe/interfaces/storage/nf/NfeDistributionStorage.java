package com.softart.dfe.interfaces.storage.nf;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfeDistributionStorage extends Storage {

    /**
     * Stores the return distribution of a given instrument
     *
     * @param o The Store object to store.
     */
    void storeRetDistribution(Store<TRetDistDFeInt> o) throws StorageException;

    /**
     * Store the distribution of the environment
     *
     * @param o The Store object to store the distribution in.
     */
    void storeEnvDistribution(Store<TDistDFeInt> o) throws StorageException;

}
