package org.dfe.components.process.mdfe.event;


import br.inf.portalfiscal.mdfe.classes.TEvento;
import br.inf.portalfiscal.mdfe.classes.TProcEvento;
import br.inf.portalfiscal.mdfe.classes.TRetEvento;
import org.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.mdfe.event.AfterEvent;
import org.dfe.interfaces.storage.mdfe.MdfeEventStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreProcEventMdfe implements AfterEvent {

    @Override
    public <T extends AfterRequest<TEvento, TRetEvento>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.response())) {
            TProcEvento procEvento = new br.inf.portalfiscal.mdfe.classes.ObjectFactory().createTProcEvento();
            procEvento.setEventoMDFe(o.request());
            procEvento.setRetEventoMDFe(o.response());
            procEvento.setVersao(o.response().getVersao());
            getStorage().storeProcEvent(new XMLStore<>(procEvento, o.config(), MdfeMarshallerFactory.getInstance().procEvent(procEvento)));
        }
    }

    protected abstract MdfeEventStorage getStorage();

}
