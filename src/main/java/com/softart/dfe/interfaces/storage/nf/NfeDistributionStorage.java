package com.softart.dfe.interfaces.storage.nf;

import br.inf.portalfiscal.nfe.distribution.TDistDFeInt;
import br.inf.portalfiscal.nfe.distribution.TRetDistDFeInt;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfeDistributionStorage extends Storage {

    void storeRetDistribution(Store<TRetDistDFeInt> o) throws StorageException;

    void storeEnvDistribution(Store<TDistDFeInt> o) throws StorageException;

}
