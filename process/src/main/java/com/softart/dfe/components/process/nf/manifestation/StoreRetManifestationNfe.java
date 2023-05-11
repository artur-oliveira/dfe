package com.softart.dfe.components.process.nf.manifestation;

import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.nf.manifestation.AfterManifestation;
import com.softart.dfe.interfaces.storage.nf.NfeManifestationStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreRetManifestationNfe implements AfterManifestation {

    @Override
    public <T extends AfterRequest<TEnvEvento, TRetEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.response()) && !data.response().getRetEvento().isEmpty()) {
            if (Objects.nonNull(getStorage()))
                getStorage().storeRetManifestation(new XMLStore<>(data.response(), data.config(), NfMarshallerFactory.getInstance().returnManifestationNfe(data.response())));
        } else {
            log.warn(data.response().getXMotivo());
        }
    }

    public abstract NfeManifestationStorage getStorage();
}
