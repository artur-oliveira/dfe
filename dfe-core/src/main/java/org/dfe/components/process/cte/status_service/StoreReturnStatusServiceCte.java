package org.dfe.components.process.cte.status_service;

import br.inf.portalfiscal.cte.send.TConsStatServ;
import br.inf.portalfiscal.cte.send.TRetConsStatServ;
import org.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.cte.status_service.AfterStatusService;
import org.dfe.interfaces.storage.cte.CteStatusServiceStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnStatusServiceCte implements AfterStatusService {

    @Override
    public <T extends AfterRequest<TConsStatServ, TRetConsStatServ>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.response()) && Objects.nonNull(getStorage())) {
            getStorage().storeReturnStatusService(new XMLStore<>(o.response(), o.config(), CteMarshallerFactory.getInstance().returnStatusService(o.response())));
        }
    }

    protected abstract CteStatusServiceStorage getStorage();

}
