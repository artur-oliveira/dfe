package com.softart.dfe.components.process.mdfe.event;


import br.inf.portalfiscal.mdfe.classes.TEvento;
import br.inf.portalfiscal.mdfe.classes.TRetEvento;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.mdfe.event.AfterEvent;
import com.softart.dfe.interfaces.storage.mdfe.MdfeEventStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;
import java.util.Optional;

public abstract class StoreReturnEventMdfe implements AfterEvent {

    @Override
    public <T extends AfterRequest<TEvento, TRetEvento>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.response())) {
            o.response().getInfEvento().setChMDFe(Optional.ofNullable(o.response().getInfEvento().getChMDFe()).orElse(o.request().getInfEvento().getChMDFe()));
            o.response().getInfEvento().setTpEvento(Optional.ofNullable(o.response().getInfEvento().getTpEvento()).orElse(o.request().getInfEvento().getTpEvento()));
            o.response().getInfEvento().setNSeqEvento(Optional.ofNullable(o.response().getInfEvento().getNSeqEvento()).orElse(o.request().getInfEvento().getNSeqEvento()));
            getStorage().storeRetEvent(new XMLStore<>(o.response(), o.config(), MdfeMarshallerFactory.getInstance().returnEvent(o.response())));
        }
    }

    protected abstract MdfeEventStorage getStorage();

}
