package com.softart.dfe.components.process.mdfe.event;


import br.inf.portalfiscal.mdfe.classes.TEvento;
import br.inf.portalfiscal.mdfe.classes.TProcEvento;
import br.inf.portalfiscal.mdfe.classes.TRetEvento;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.mdfe.event.AfterEvent;
import com.softart.dfe.interfaces.storage.mdfe.MdfeEventStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreProcEventMdfe implements AfterEvent {

    @Override
    public <T extends AfterRequest<TEvento, TRetEvento>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.getResponse())) {
            TProcEvento procEvento = new br.inf.portalfiscal.mdfe.classes.ObjectFactory().createTProcEvento();
            procEvento.setEventoMDFe(o.getRequest());
            procEvento.setRetEventoMDFe(o.getResponse());
            procEvento.setVersao(o.getResponse().getVersao());
            getStorage().storeProcEvent(new XMLStore<>(procEvento, o.getConfig(), MdfeMarshallerFactory.getInstance().procEvent(procEvento)));
        }
    }

    protected abstract MdfeEventStorage getStorage();

}
