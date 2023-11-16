package org.dfe.components.process.mdfe.event;

import br.inf.portalfiscal.mdfe.classes.TEvento;
import org.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.mdfe.event.BeforeEvent;
import org.dfe.interfaces.storage.mdfe.MdfeEventStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreEventMdfe implements BeforeEvent {

    @Override
    public <T extends BeforeRequest<TEvento>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.request()) && Objects.nonNull(getStorage())) {
            getStorage().storeSendEvent(new XMLStore<>(o.request(), o.config(), MdfeMarshallerFactory.getInstance().sendEvent(o.request())));
        }
    }

    protected abstract MdfeEventStorage getStorage();
}
