package com.softart.dfe.interfaces.storage.nf;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento;
import com.softart.dfe.exceptions.storage.StorageException;
import com.softart.dfe.interfaces.storage.Storage;
import com.softart.dfe.interfaces.storage.Store;

public interface NfeInterestedActorStorage extends Storage {

    void storeProcInterestedActor(Store<TProcEvento> o) throws StorageException;

    void storeRetInterestedActor(Store<TRetEnvEvento> o) throws StorageException;

    void storeSendInterestedActor(Store<TEnvEvento> o) throws StorageException;

}
