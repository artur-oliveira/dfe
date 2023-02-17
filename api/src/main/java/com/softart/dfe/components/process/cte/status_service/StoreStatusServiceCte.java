package com.softart.dfe.components.process.cte.status_service;

import br.inf.portalfiscal.cte.send.TConsStatServ;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.cte.status_service.BeforeStatusService;
import com.softart.dfe.interfaces.storage.cte.CteStatusServiceStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreStatusServiceCte implements BeforeStatusService {

    @Override
    public <T extends BeforeRequest<TConsStatServ>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.getRequest()) && Objects.nonNull(getStorage())) {
            getStorage().storeStatusService(new XMLStore<>(o.getRequest(), o.getConfig(), CteMarshallerFactory.getInstance().statusService(o.getRequest())));
        }
    }

    protected abstract CteStatusServiceStorage getStorage();
}
