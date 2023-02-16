package com.softart.dfe.components.process.nf.manifestation;

import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.nf.manifestation.BeforeManifestation;
import com.softart.dfe.interfaces.storage.nf.NfeManifestationStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreSendManifestationNfe implements BeforeManifestation {

    @Override
    public <T extends BeforeRequest<TEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.getRequest()) && !data.getRequest().getEvento().isEmpty())
            if (Objects.nonNull(getStorage()))
                getStorage().storeSendManifestation(new XMLStore<>(data.getRequest(), data.getConfig(), NfMarshallerFactory.getInstance().manifestationNfe(data.getRequest())));

    }

    public abstract NfeManifestationStorage getStorage();
}
