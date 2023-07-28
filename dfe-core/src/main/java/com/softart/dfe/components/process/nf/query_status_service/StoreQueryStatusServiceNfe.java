package com.softart.dfe.components.process.nf.query_status_service;

import br.inf.portalfiscal.nfe.send.TConsStatServ;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.nf.query_status_service.BeforeQueryStatusService;
import com.softart.dfe.interfaces.storage.nf.common.NfQueryStatusServiceStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

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
