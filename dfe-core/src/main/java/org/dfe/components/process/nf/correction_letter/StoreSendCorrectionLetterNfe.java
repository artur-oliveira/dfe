package org.dfe.components.process.nf.correction_letter;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.nf.correction_letter.BeforeCorrectionLetter;
import org.dfe.interfaces.storage.nf.NfeCorrectionLetterStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

public abstract class StoreSendCorrectionLetterNfe implements BeforeCorrectionLetter {

    @Override
    public <T extends BeforeRequest<TEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request()) && !data.request().getEvento().isEmpty())
            if (Objects.nonNull(getStorage()))
                getStorage().storeSendCorrectionLetter(new XMLStore<>(data.request(), data.config(), NfMarshallerFactory.getInstance().correctionLetterNfe(data.request())));

    }

    public abstract NfeCorrectionLetterStorage getStorage();
}
