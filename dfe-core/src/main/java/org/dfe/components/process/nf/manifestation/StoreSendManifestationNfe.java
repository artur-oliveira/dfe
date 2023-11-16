package org.dfe.components.process.nf.manifestation;

import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.nf.manifestation.BeforeManifestation;
import org.dfe.interfaces.storage.nf.NfeManifestationStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreSendManifestationNfe implements BeforeManifestation {

    @Override
    public <T extends BeforeRequest<TEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request()) && !data.request().getEvento().isEmpty())
            if (Objects.nonNull(getStorage()))
                getStorage().storeSendManifestation(new XMLStore<>(data.request(), data.config(), NfMarshallerFactory.getInstance().manifestationNfe(data.request())));

    }

    public abstract NfeManifestationStorage getStorage();
}
