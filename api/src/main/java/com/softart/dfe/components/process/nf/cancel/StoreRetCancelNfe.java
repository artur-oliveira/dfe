package com.softart.dfe.components.process.nf.cancel;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.nf.cancel.AfterCancel;
import com.softart.dfe.interfaces.storage.nf.common.NfCancelStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreRetCancelNfe implements AfterCancel {

    @Override
    public <T extends AfterRequest<TEnvEvento, TRetEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.getResponse()) && !data.getResponse().getRetEvento().isEmpty()) {
            if (Objects.nonNull(getStorage()))
                getStorage().storeRetCancel(new XMLStore<>(data.getResponse(), data.getConfig(), NfMarshallerFactory.getInstance().returnCancelNfe(data.getResponse())));
        } else if (Objects.nonNull(data.getResponse())) {
            log.warn(data.getResponse().getXMotivo());
        }
    }

    public abstract NfCancelStorage getStorage();
}
