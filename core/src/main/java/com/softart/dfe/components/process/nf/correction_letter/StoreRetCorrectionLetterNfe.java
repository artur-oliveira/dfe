package com.softart.dfe.components.process.nf.correction_letter;

import br.inf.portalfiscal.nfe.event_correction_letter.TEnvEvento;
import br.inf.portalfiscal.nfe.event_correction_letter.TRetEnvEvento;
import br.inf.portalfiscal.nfe.event_correction_letter.TretEvento;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.nf.correction_letter.AfterCorrectionLetter;
import com.softart.dfe.interfaces.storage.nf.NfeCorrectionLetterStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;
import java.util.Optional;

@Log4j2
public abstract class StoreRetCorrectionLetterNfe implements AfterCorrectionLetter {

    @Override
    public <T extends AfterRequest<TEnvEvento, TRetEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.response()) && !data.response().getRetEvento().isEmpty()) {
            for (int i = 0; i < data.response().getRetEvento().size(); i++) {
                TretEvento o = data.response().getRetEvento().get(i);
                o.getInfEvento().setChNFe(Optional.ofNullable(o.getInfEvento().getChNFe()).orElse(data.request().getEvento().get(i).getInfEvento().getChNFe()));
                o.getInfEvento().setTpEvento(Optional.ofNullable(o.getInfEvento().getTpEvento()).orElse(data.request().getEvento().get(i).getInfEvento().getTpEvento()));
                o.getInfEvento().setNSeqEvento(Optional.ofNullable(o.getInfEvento().getNSeqEvento()).orElse(data.request().getEvento().get(i).getInfEvento().getNSeqEvento()));
            }
            if (Objects.nonNull(getStorage()))
                getStorage().storeRetCorrectionLetter(new XMLStore<>(data.response(), data.config(), NfMarshallerFactory.getInstance().returnCorrectionLetterNfe(data.response())));
        } else if (Objects.nonNull(data.response())) {
            log.warn(data.response().getXMotivo());
        }
    }

    public abstract NfeCorrectionLetterStorage getStorage();
}