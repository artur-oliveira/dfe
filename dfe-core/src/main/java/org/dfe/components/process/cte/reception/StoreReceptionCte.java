package org.dfe.components.process.cte.reception;

import br.inf.portalfiscal.cte.send.TEnviCTe;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.cte.reception.BeforeReception;
import org.dfe.interfaces.storage.cte.CteReceptionStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReceptionCte implements BeforeReception {

    @Override
    public <T extends BeforeRequest<TEnviCTe>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.request()) && Objects.nonNull(getStorage())) {
            getStorage().storeCte(new XMLStore<>(o.request(), o.config(), CteMarshallerFactory.getInstance().receptionCte(o.request())));
        }
    }

    protected abstract CteReceptionStorage getStorage();
}
