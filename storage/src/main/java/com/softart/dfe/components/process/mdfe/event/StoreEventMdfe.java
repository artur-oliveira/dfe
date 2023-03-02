package com.softart.dfe.components.process.mdfe.event;

import br.inf.portalfiscal.mdfe.classes.TEvento;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.mdfe.event.BeforeEvent;
import com.softart.dfe.interfaces.storage.mdfe.MdfeEventStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreEventMdfe implements BeforeEvent {

    @Override
    public <T extends BeforeRequest<TEvento>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.getRequest()) && Objects.nonNull(getStorage())) {
            getStorage().storeSendEvent(new XMLStore<>(o.getRequest(), o.getConfig(), MdfeMarshallerFactory.getInstance().sendEvent(o.getRequest())));
        }
    }

    protected abstract MdfeEventStorage getStorage();
}
