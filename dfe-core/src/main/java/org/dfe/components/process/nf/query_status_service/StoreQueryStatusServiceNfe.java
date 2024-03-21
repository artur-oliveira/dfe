package org.dfe.components.process.nf.query_status_service;

import br.inf.portalfiscal.nfe.send.TConsStatServ;
import lombok.extern.log4j.Log4j2;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.nf.query_status_service.BeforeQueryStatusService;
import org.dfe.interfaces.storage.nf.common.NfQueryStatusServiceStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

@Log4j2
public abstract class StoreQueryStatusServiceNfe implements BeforeQueryStatusService {

    @Override
    public <T extends BeforeRequest<TConsStatServ>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request())) if (Objects.nonNull(getStorage()))
            getStorage().storeSendQueryStatusService(new XMLStore<>(data.request(), data.config(), NfMarshallerFactory.getInstance().queryStatusServiceNfe(data.request())));
    }

    public abstract NfQueryStatusServiceStorage getStorage();
}
