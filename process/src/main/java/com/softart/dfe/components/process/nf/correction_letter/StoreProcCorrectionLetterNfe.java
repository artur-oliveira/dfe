package com.softart.dfe.components.process.nf.correction_letter;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import br.inf.portalfiscal.nfe.event_correction_letter.TProcEvento;
import br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.nf.correction_letter.AfterCorrectionLetter;
import com.softart.dfe.interfaces.storage.nf.NfeCorrectionLetterStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreProcCorrectionLetterNfe implements AfterCorrectionLetter {

    @Override
    public <T extends AfterRequest<TEnvEvento, TRetEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.getRequest()) && !data.getRequest().getEvento().isEmpty() && Objects.nonNull(data.getResponse()) && !data.getResponse().getRetEvento().isEmpty()) {
            for (int i = 0; i < data.getRequest().getEvento().size(); i++) {
                TProcEvento procEvento = new br.inf.portalfiscal.nfe.event_correction_letter.ObjectFactory().createTProcEvento();
                procEvento.setEvento(data.getRequest().getEvento().get(i));
                procEvento.setRetEvento(data.getResponse().getRetEvento().get(i));
                procEvento.setVersao(procEvento.getRetEvento().getVersao());

                if (Objects.nonNull(getStorage())) {
                    getStorage().storeProcCorrectionLetter(new XMLStore<>(procEvento, data.getConfig(), NfMarshallerFactory.getInstance().procCorrectionLetterNfe(procEvento)));
                }
            }
        } else if (Objects.nonNull(data.getResponse())) {
            log.warn(data.getResponse().getXMotivo());
        }
    }


    public abstract NfeCorrectionLetterStorage getStorage();
}
