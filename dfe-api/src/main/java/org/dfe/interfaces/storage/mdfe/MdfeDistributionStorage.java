package org.dfe.interfaces.storage.mdfe;

import br.inf.portalfiscal.mdfe.classes.TDistDFe;
import br.inf.portalfiscal.mdfe.classes.TRetDistDFe;
import org.dfe.exceptions.storage.StorageException;
import org.dfe.interfaces.storage.Storage;
import org.dfe.interfaces.storage.Store;

public interface MdfeDistributionStorage extends Storage {

    /**
     * It stores the return distribution of the current DFE.
     *
     * @param o The Store object to store the data in.
     * @throws StorageException StorageException
     */
    void storeRetDistribution(Store<TRetDistDFe> o) throws StorageException;

    /**
     * Store a distribution of DFeInts
     *
     * @param o The object to be stored.
     * @throws StorageException StorageException
     */
    void storeSendDistribution(Store<TDistDFe> o) throws StorageException;

}
