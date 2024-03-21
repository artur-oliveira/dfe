package org.dfe.components.process.nf.query_status_service;

import br.inf.portalfiscal.nfe.send.TConsStatServ;
import br.inf.portalfiscal.nfe.send.TRetConsStatServ;
import lombok.extern.log4j.Log4j2;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.nf.query_status_service.AfterQueryStatusService;
import org.dfe.interfaces.storage.nf.common.NfQueryStatusServiceStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

@Log4j2
public abstract class StoreReturnQueryStatusServiceNfe implements AfterQueryStatusService {

    @Override
    public <T extends AfterRequest<TConsStatServ, TRetConsStatServ>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.response())) {
            if (Objects.nonNull(getStorage()))
                getStorage().storeReturnQueryStatusService(new XMLStore<>(data.response(), data.config(), NfMarshallerFactory.getInstance().returnQueryStatusServiceNfe(data.response())));
        } else {
            log.warn(Objects.requireNonNull(data.response()).getXMotivo());
        }

    }

    public abstract NfQueryStatusServiceStorage getStorage();
}
