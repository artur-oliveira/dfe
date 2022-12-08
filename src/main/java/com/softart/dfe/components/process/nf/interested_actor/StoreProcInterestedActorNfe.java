package com.softart.dfe.components.process.nf.interested_actor;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.nf.interested_actor.AfterInterestedActor;
import com.softart.dfe.interfaces.storage.nf.NfeInterestedActorStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshaller;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreProcInterestedActorNfe implements AfterInterestedActor {

    @Override
    public <T extends AfterRequest<TEnvEvento, TRetEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.getRequest()) && !data.getRequest().getEvento().isEmpty() && Objects.nonNull(data.getResponse()) && !data.getResponse().getRetEvento().isEmpty()) {
            TProcEvento procEvento = new br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory().createTProcEvento();
            procEvento.setEvento(data.getRequest().getEvento().get(0));
            procEvento.setRetEvento(data.getResponse().getRetEvento().get(0));
            procEvento.setVersao(procEvento.getRetEvento().getVersao());

            if (Objects.nonNull(getStorage()))
                getStorage().storeProcInterestedActor(new XMLStore<>(procEvento, data.getConfig(), NfMarshaller.procInterestedActorNfe(procEvento)));
        } else if (Objects.nonNull(data.getResponse())) {
            log.warn(data.getResponse().getXMotivo());
        }
    }


    public abstract NfeInterestedActorStorage getStorage();
}
