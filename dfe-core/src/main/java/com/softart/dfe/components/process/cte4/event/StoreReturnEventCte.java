package com.softart.dfe.components.process.cte4.event;


import br.inf.portalfiscal.cte.send400.TEvento;
import br.inf.portalfiscal.cte.send400.TRetEvento;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.cte4.event.AfterEvent;
import com.softart.dfe.interfaces.storage.cte4.CteEventStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

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
