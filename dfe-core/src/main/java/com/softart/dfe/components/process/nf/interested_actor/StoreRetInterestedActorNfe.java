package com.softart.dfe.components.process.nf.interested_actor;

import br.inf.portalfiscal.nfe.event_interested_actor.TEnvEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TRetEnvEvento;
import br.inf.portalfiscal.nfe.event_interested_actor.TRetEvento;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.nf.interested_actor.AfterInterestedActor;
import com.softart.dfe.interfaces.storage.nf.NfeInterestedActorStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;
import java.util.Optional;

@Log4j2
public abstract class StoreRetInterestedActorNfe implements AfterInterestedActor {

    @Override
    public <T extends AfterRequest<TEnvEvento, TRetEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.response()) && !data.response().getRetEvento().isEmpty()) {
            for (int i = 0; i < data.response().getRetEvento().size(); i++) {
                TRetEvento o = data.response().getRetEvento().get(i);
                o.getInfEvento().setChNFe(Optional.ofNullable(o.getInfEvento().getChNFe()).orElse(data.request().getEvento().get(i).getInfEvento().getChNFe()));
                o.getInfEvento().setTpEvento(Optional.ofNullable(o.getInfEvento().getTpEvento()).orElse(data.request().getEvento().get(i).getInfEvento().getTpEvento()));
                o.getInfEvento().setNSeqEvento(Optional.ofNullable(o.getInfEvento().getNSeqEvento()).orElse(data.request().getEvento().get(i).getInfEvento().getNSeqEvento()));
            }
            if (Objects.nonNull(getStorage()))
                getStorage().storeRetInterestedActor(new XMLStore<>(data.response(), data.config(), NfMarshallerFactory.getInstance().returnInterestedActorNfe(data.response())));
        } else if (Objects.nonNull(data.response())) {
            log.warn(data.response().getXMotivo());
        }
    }

    public abstract NfeInterestedActorStorage getStorage();
}
