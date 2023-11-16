package org.dfe.interfaces.storage.nf;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Storage;
import org.dfe.interfaces.storage.Store;

public interface NfeDistributionStorage extends Storage {

    /**
     * Stores the return distribution of a given instrument
     *
     * @param o The Store object to store.
     * @throws StorageException StorageException
     */
    void storeRetDistribution(Store<TRetDistDFeInt> o) throws StorageException;

    /**
     * Store the distribution of the environment
     *
     * @param o The Store object to store the distribution in.
     * @throws StorageException StorageException
     */
    void storeEnvDistribution(Store<TDistDFeInt> o) throws StorageException;

}
