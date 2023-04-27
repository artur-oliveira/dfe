package com.softart.dfe.components.process.mdfe.status_service;

import br.inf.portalfiscal.mdfe.classes.TConsStatServ;
import br.inf.portalfiscal.mdfe.classes.TRetConsStatServ;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.mdfe.status_service.AfterStatusService;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStatusServiceStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreReturnStatusServiceMdfe implements AfterStatusService {

    @Override
    public <T extends AfterRequest<TConsStatServ, TRetConsStatServ>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.getConfig()) && Objects.nonNull(o.getRequest())) {
            getStorage().storeReturnStatusService(new XMLStore<>(o.getResponse(), o.getConfig(), MdfeMarshallerFactory.getInstance().returnStatusService(o.getResponse())));
        }
    }

    public abstract MdfeStatusServiceStorage getStorage();

}
