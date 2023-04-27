package com.softart.dfe.components.process.nf.epec;

import br.inf.portalfiscal.nfe.event_epec.TEnvEvento;
import br.inf.portalfiscal.nfe.event_epec.TRetEnvEvento;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.nf.epec.AfterEpec;
import com.softart.dfe.interfaces.storage.nf.NfeEpecStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreRetEpecNfe implements AfterEpec {

    @Override
    public <T extends AfterRequest<TEnvEvento, TRetEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.getResponse()) && !data.getResponse().getRetEvento().isEmpty()) {
            if (Objects.nonNull(getStorage()))
                getStorage().storeRetEpec(new XMLStore<>(data.getResponse(), data.getConfig(), NfMarshallerFactory.getInstance().returnEpecNfe(data.getResponse())));
        } else if (Objects.nonNull(data.getResponse())) {
            log.warn(data.getResponse().getXMotivo());
        }
    }

    public abstract NfeEpecStorage getStorage();
}
