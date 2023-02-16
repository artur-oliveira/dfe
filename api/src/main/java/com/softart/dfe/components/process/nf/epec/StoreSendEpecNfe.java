package com.softart.dfe.components.process.nf.epec;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.nf.epec.BeforeEpec;
import com.softart.dfe.interfaces.storage.nf.NfeEpecStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreSendEpecNfe implements BeforeEpec {

    @Override
    public <T extends BeforeRequest<TEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.getRequest()) && !data.getRequest().getEvento().isEmpty())
            if (Objects.nonNull(getStorage()))
                getStorage().storeSendEpec(new XMLStore<>(data.getRequest(), data.getConfig(), NfMarshallerFactory.getInstance().epecNfe(data.getRequest())));

    }

    public abstract NfeEpecStorage getStorage();
}
