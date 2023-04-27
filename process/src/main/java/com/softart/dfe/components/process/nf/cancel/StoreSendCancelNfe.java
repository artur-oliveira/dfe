package com.softart.dfe.components.process.nf.cancel;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.nf.cancel.BeforeCancel;
import com.softart.dfe.interfaces.storage.nf.common.NfCancelStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreSendCancelNfe implements BeforeCancel {

    @Override
    public <T extends BeforeRequest<TEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.getRequest()) && !data.getRequest().getEvento().isEmpty())
            if (Objects.nonNull(getStorage()))
                getStorage().storeSendCancel(new XMLStore<>(data.getRequest(), data.getConfig(), NfMarshallerFactory.getInstance().cancelNfe(data.getRequest())));

    }

    public abstract NfCancelStorage getStorage();
}
