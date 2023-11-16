package org.dfe.components.process.cte4.event;


import br.inf.portalfiscal.cte.send400.TEvento;
import br.inf.portalfiscal.cte.send400.TProcEvento;
import br.inf.portalfiscal.cte.send400.TRetEvento;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.cte4.event.AfterEvent;
import org.dfe.interfaces.storage.cte4.CteEventStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreProcEventCte implements AfterEvent {

    @Override
    public <T extends AfterRequest<TEvento, TRetEvento>> void process(T o) throws ProcessException {
        if (Objects.nonNull(getStorage()) && Objects.nonNull(o.response())) {
            TProcEvento procEvento = new br.inf.portalfiscal.cte.send400.ObjectFactory().createTProcEvento();
            procEvento.setEventoCTe(o.request());
            procEvento.setRetEventoCTe(o.response());
            procEvento.setVersao(o.response().getVersao());
            getStorage().storeProcEvent(new XMLStore<>(procEvento, o.config(), CteMarshallerFactory.getInstance().procEventCte(procEvento)));
        }
    }

    protected abstract CteEventStorage getStorage();

}
