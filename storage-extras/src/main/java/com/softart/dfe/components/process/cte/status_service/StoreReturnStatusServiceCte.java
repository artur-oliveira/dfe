package com.softart.dfe.components.process.cte.status_service;

import br.inf.portalfiscal.cte.send.TConsStatServ;
import br.inf.portalfiscal.cte.send.TRetConsStatServ;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.cte.status_service.AfterStatusService;
import com.softart.dfe.interfaces.storage.cte.CteStatusServiceStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnStatusServiceCte implements AfterStatusService {

    @Override
    public <T extends AfterRequest<TConsStatServ, TRetConsStatServ>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.getResponse()) && Objects.nonNull(getStorage())) {
            getStorage().storeReturnStatusService(new XMLStore<>(o.getResponse(), o.getConfig(), CteMarshallerFactory.getInstance().returnStatusService(o.getResponse())));
        }
    }

    protected abstract CteStatusServiceStorage getStorage();

}
