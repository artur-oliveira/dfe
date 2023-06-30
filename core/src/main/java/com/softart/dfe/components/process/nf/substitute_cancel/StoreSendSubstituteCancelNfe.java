package com.softart.dfe.components.process.nf.substitute_cancel;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.BeforeSubstituteCancel;
import com.softart.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreSendSubstituteCancelNfe implements BeforeSubstituteCancel {

    @Override
    public <T extends BeforeRequest<TEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request()) && !data.request().getEvento().isEmpty())
            if (Objects.nonNull(getStorage()))
                getStorage().storeSendSubstituteCancel(new XMLStore<>(data.request(), data.config(), NfMarshallerFactory.getInstance().substituteCancelNfe(data.request())));

    }

    public abstract NfceSubstituteCancelStorage getStorage();
}
