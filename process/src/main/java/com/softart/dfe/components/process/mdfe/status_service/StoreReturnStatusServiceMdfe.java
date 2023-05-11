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
        if (Objects.nonNull(o.config()) && Objects.nonNull(o.request())) {
            getStorage().storeReturnStatusService(new XMLStore<>(o.response(), o.config(), MdfeMarshallerFactory.getInstance().returnStatusService(o.response())));
        }
    }

    public abstract MdfeStatusServiceStorage getStorage();

}
