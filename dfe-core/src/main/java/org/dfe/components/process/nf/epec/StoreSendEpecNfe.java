package org.dfe.components.process.nf.epec;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.nf.epec.BeforeEpec;
import org.dfe.interfaces.storage.nf.NfeEpecStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreSendEpecNfe implements BeforeEpec {

    @Override
    public <T extends BeforeRequest<TEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request()) && !data.request().getEvento().isEmpty())
            if (Objects.nonNull(getStorage()))
                getStorage().storeSendEpec(new XMLStore<>(data.request(), data.config(), NfMarshallerFactory.getInstance().epecNfe(data.request())));

    }

    public abstract NfeEpecStorage getStorage();
}
