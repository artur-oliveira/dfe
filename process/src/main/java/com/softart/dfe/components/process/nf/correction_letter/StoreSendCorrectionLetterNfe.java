package com.softart.dfe.components.process.nf.correction_letter;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.BeforeRequest;
import com.softart.dfe.interfaces.process.nf.correction_letter.BeforeCorrectionLetter;
import com.softart.dfe.interfaces.storage.nf.NfeCorrectionLetterStorage;
import com.softart.dfe.models.internal.xml.XMLStore;

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
