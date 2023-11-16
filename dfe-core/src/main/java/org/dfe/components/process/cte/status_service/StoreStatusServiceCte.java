package org.dfe.components.process.cte.status_service;

import br.inf.portalfiscal.cte.send.TConsStatServ;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.cte.status_service.BeforeStatusService;
import org.dfe.interfaces.storage.cte.CteStatusServiceStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreStatusServiceCte implements BeforeStatusService {

    @Override
    public <T extends BeforeRequest<TConsStatServ>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.request()) && Objects.nonNull(getStorage())) {
            getStorage().storeStatusService(new XMLStore<>(o.request(), o.config(), CteMarshallerFactory.getInstance().statusService(o.request())));
        }
    }

    protected abstract CteStatusServiceStorage getStorage();
}
