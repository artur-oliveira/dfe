package org.dfe.components.process.cte4.event;

import br.inf.portalfiscal.cte.send400.TEvento;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.cte4.event.BeforeEvent;
import org.dfe.interfaces.storage.cte4.CteEventStorage;
import org.dfe.models.internal.xml.XMLStore;

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
