package org.dfe.components.process.mdfe.status_service;

import br.inf.portalfiscal.mdfe.classes.TConsStatServ;
import br.inf.portalfiscal.mdfe.classes.TRetConsStatServ;
import org.dfe.components.internal.xml.marshaller.MdfeMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.mdfe.status_service.AfterStatusService;
import org.dfe.interfaces.storage.mdfe.MdfeStatusServiceStorage;
import org.dfe.models.internal.xml.XMLStore;

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
