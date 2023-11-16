package org.dfe.components.process.nf.interested_actor;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TProcEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.nf.interested_actor.AfterInterestedActor;
import org.dfe.interfaces.storage.nf.NfeInterestedActorStorage;
import org.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreProcInterestedActorNfe implements AfterInterestedActor {

    @Override
    public <T extends AfterRequest<TEnvEvento, TRetEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request()) && !data.request().getEvento().isEmpty() && Objects.nonNull(data.response()) && !data.response().getRetEvento().isEmpty()) {
            for (int i = 0; i < data.request().getEvento().size(); i++) {
                TProcEvento procEvento = new br.inf.portalfiscal.nfe.event_interested_actor.ObjectFactory().createTProcEvento();
                procEvento.setEvento(data.request().getEvento().get(i));
                procEvento.setRetEvento(data.response().getRetEvento().get(i));
                procEvento.setVersao(procEvento.getRetEvento().getVersao());

                if (Objects.nonNull(getStorage())) {
                    getStorage().storeProcInterestedActor(new XMLStore<>(procEvento, data.config(), NfMarshallerFactory.getInstance().procInterestedActorNfe(procEvento)));
                }
            }
        } else if (Objects.nonNull(data.response())) {
            log.warn(data.response().getXMotivo());
        }
    }


    public abstract NfeInterestedActorStorage getStorage();
}
