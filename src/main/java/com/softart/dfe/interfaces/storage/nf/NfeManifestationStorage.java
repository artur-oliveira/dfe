package com.softart.dfe.interfaces.storage.nf;

import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TProcEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfeManifestationStorage extends Storage {
    void storeProcManifestation(Store<TProcEvento> o) throws StorageException;

    void storeRetManifestation(Store<TRetEnvEvento> o) throws StorageException;

    void storeSendManifestation(Store<TEnvEvento> o) throws StorageException;

}
