package com.softart.dfe.components.process.nf.manifestation;

import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TProcEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.nf.manifestation.AfterManifestation;
import com.softart.dfe.interfaces.storage.nf.NfeManifestationStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshaller;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreProcManifestationNfe implements AfterManifestation {

    @Override
    public <T extends AfterRequest<TEnvEvento, TRetEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.getRequest()) && !data.getRequest().getEvento().isEmpty() && Objects.nonNull(data.getResponse()) && !data.getResponse().getRetEvento().isEmpty()) {
            TProcEvento procEvento = new br.inf.portalfiscal.nfe.event_manifestation.ObjectFactory().createTProcEvento();
            procEvento.setEvento(data.getRequest().getEvento().get(0));
            procEvento.setRetEvento(data.getResponse().getRetEvento().get(0));
            procEvento.setVersao(procEvento.getRetEvento().getVersao());

            if (Objects.nonNull(getStorage()))
                getStorage().storeProcManifestation(new XMLStore<>(procEvento, data.getConfig(), NfMarshaller.procManifestationNfe(procEvento)));
        } else {
            log.warn(data.getResponse().getXMotivo());
        }
    }


    public abstract NfeManifestationStorage getStorage();
}
