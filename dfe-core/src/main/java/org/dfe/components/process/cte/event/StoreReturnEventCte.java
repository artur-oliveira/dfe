package org.dfe.components.process.cte.event;


import br.inf.portalfiscal.cte.send.TEvento;
import br.inf.portalfiscal.cte.send.TRetEvento;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.cte.event.AfterEvent;
import org.dfe.interfaces.storage.cte.CteEventStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;
import java.util.Optional;

public abstract class StoreReturnEventCte implements AfterEvent {

    @Override
    public <T extends AfterRequest<TEvento, TRetEvento>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.response())) {
            o.response().getInfEvento().setChCTe(Optional.ofNullable(o.response().getInfEvento().getChCTe()).orElse(o.request().getInfEvento().getChCTe()));
            o.response().getInfEvento().setTpEvento(Optional.ofNullable(o.response().getInfEvento().getTpEvento()).orElse(o.request().getInfEvento().getTpEvento()));
            o.response().getInfEvento().setNSeqEvento(Optional.ofNullable(o.response().getInfEvento().getNSeqEvento()).orElse(o.request().getInfEvento().getNSeqEvento()));
            getStorage().storeReturnEvent(new XMLStore<>(o.response(), o.config(), CteMarshallerFactory.getInstance().returnEventCte(o.response())));
        }
    }

    protected abstract CteEventStorage getStorage();

}
