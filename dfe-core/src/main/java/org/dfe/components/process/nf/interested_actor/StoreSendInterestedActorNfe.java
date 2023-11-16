package org.dfe.components.process.nf.interested_actor;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.nf.interested_actor.BeforeInterestedActor;
import org.dfe.interfaces.storage.nf.NfeInterestedActorStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreSendInterestedActorNfe implements BeforeInterestedActor {

    @Override
    public <T extends BeforeRequest<TEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request()) && !data.request().getEvento().isEmpty())
            if (Objects.nonNull(getStorage()))
                getStorage().storeSendInterestedActor(new XMLStore<>(data.request(), data.config(), NfMarshallerFactory.getInstance().interestedActorNfe(data.request())));

    }

    public abstract NfeInterestedActorStorage getStorage();
}
