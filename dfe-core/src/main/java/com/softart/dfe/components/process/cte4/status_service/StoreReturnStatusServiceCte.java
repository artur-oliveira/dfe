package com.softart.dfe.components.process.cte4.status_service;

import br.inf.portalfiscal.cte.send400.TConsStatServ;
import br.inf.portalfiscal.cte.send400.TRetConsStatServ;
import com.softart.dfe.components.internal.xml.marshaller.CteMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.cte4.status_service.AfterStatusService;
import com.softart.dfe.interfaces.storage.cte4.CteStatusServiceStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

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
