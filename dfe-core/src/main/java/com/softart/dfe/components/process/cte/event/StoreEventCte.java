package com.softart.dfe.components.process.cte.event;

import br.inf.portalfiscal.cte.send.TEvento;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.cte.event.BeforeEvent;
import com.softart.dfe.interfaces.storage.cte.CteEventStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreEventCte implements BeforeEvent {

    @Override
    public <T extends BeforeRequest<TEvento>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.request()) && Objects.nonNull(getStorage())) {
            getStorage().storeEvent(new XMLStore<>(o.request(), o.config(), CteMarshallerFactory.getInstance().eventCte(o.request())));
        }
    }

    protected abstract CteEventStorage getStorage();
}
