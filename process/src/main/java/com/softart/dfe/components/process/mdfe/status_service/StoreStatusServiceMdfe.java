package com.softart.dfe.components.process.mdfe.status_service;

import br.inf.portalfiscal.mdfe.classes.TConsStatServ;
import com.softart.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.mdfe.status_service.BeforeStatusService;
import com.softart.dfe.interfaces.storage.mdfe.MdfeStatusServiceStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreStatusServiceMdfe implements BeforeStatusService {

    @Override
    public <T extends BeforeRequest<TConsStatServ>> void process(T o) throws ProcessException {
        if (Objects.nonNull(o.config()) && Objects.nonNull(o.request())) {
            getStorage().storeStatusService(new XMLStore<>(o.request(), o.config(), MdfeMarshallerFactory.getInstance().sendStatusService(o.request())));
        }
    }

    public abstract MdfeStatusServiceStorage getStorage();

}
