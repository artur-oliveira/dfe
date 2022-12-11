package com.softart.dfe.interfaces.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.DistDFeInt;
import br.inf.portalfiscal.mdfe.classes.RetDistDFeInt;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface MdfeDistributionStorage extends Storage {

    void storeRetDistribution(Store<RetDistDFeInt> o) throws StorageException;

    void storeSendDistribution(Store<DistDFeInt> o) throws StorageException;

}
