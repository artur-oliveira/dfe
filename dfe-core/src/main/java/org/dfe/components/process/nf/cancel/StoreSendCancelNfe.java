package org.dfe.components.process.nf.cancel;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.nf.cancel.BeforeCancel;
import org.dfe.interfaces.storage.nf.common.NfCancelStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreSendCancelNfe implements BeforeCancel {

    @Override
    public <T extends BeforeRequest<TEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request()) && !data.request().getEvento().isEmpty())
            if (Objects.nonNull(getStorage()))
                getStorage().storeSendCancel(new XMLStore<>(data.request(), data.config(), NfMarshallerFactory.getInstance().cancelNfe(data.request())));

    }

    public abstract NfCancelStorage getStorage();
}
