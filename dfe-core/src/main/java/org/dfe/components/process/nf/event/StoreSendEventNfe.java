package org.dfe.components.process.nf.event;

import br.inf.portalfiscal.nfe.event_generic.TEnvEvento;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.nf.event.BeforeEvent;
import org.dfe.interfaces.storage.nf.common.NfEventStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreSendEventNfe implements BeforeEvent {

    @Override
    public <T extends BeforeRequest<TEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request()) && !data.request().getEvento().isEmpty())
            if (Objects.nonNull(getStorage()))
                getStorage().storeSendEvent(new XMLStore<>(data.request(), data.config(), NfMarshallerFactory.getInstance().eventNfe(data.request())));

    }

    public abstract NfEventStorage getStorage();
}
