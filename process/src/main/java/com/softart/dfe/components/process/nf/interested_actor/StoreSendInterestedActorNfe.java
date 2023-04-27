package com.softart.dfe.components.process.nf.interested_actor;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.nf.interested_actor.BeforeInterestedActor;
import com.softart.dfe.interfaces.storage.nf.NfeInterestedActorStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreSendInterestedActorNfe implements BeforeInterestedActor {

    @Override
    public <T extends BeforeRequest<TEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.getRequest()) && !data.getRequest().getEvento().isEmpty())
            if (Objects.nonNull(getStorage()))
                getStorage().storeSendInterestedActor(new XMLStore<>(data.getRequest(), data.getConfig(), NfMarshallerFactory.getInstance().interestedActorNfe(data.getRequest())));

    }

    public abstract NfeInterestedActorStorage getStorage();
}
