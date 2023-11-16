package org.dfe.components.process.nf.substitute_cancel;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.nf.substitute_cancel.BeforeSubstituteCancel;
import org.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;
import org.dfe.models.internal.xml.XMLStore;

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
