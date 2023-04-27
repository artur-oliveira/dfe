package com.softart.dfe.components.process.nf.substitute_cancel;

import br.inf.portalfiscal.nfe.event_substitute_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TProcEvento;
import br.inf.portalfiscal.nfe.event_substitute_cancel.TRetEnvEvento;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.nf.substitute_cancel.AfterSubstituteCancel;
import com.softart.dfe.interfaces.storage.nf.NfceSubstituteCancelStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreProcSubstituteCancelNfe implements AfterSubstituteCancel {

    @Override
    public <T extends AfterRequest<TEnvEvento, TRetEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.getRequest()) && !data.getRequest().getEvento().isEmpty() && Objects.nonNull(data.getResponse()) && !data.getResponse().getRetEvento().isEmpty()) {
            for (int i = 0; i < data.getRequest().getEvento().size(); i++) {
                TProcEvento procEvento = new br.inf.portalfiscal.nfe.event_substitute_cancel.ObjectFactory().createTProcEvento();
                procEvento.setEvento(data.getRequest().getEvento().get(i));
                procEvento.setRetEvento(data.getResponse().getRetEvento().get(i));
                procEvento.setVersao(procEvento.getRetEvento().getVersao());

                if (Objects.nonNull(getStorage())) {
                    getStorage().storeProcSubstituteCancel(new XMLStore<>(procEvento, data.getConfig(), NfMarshallerFactory.getInstance().procSubstituteCancelNfe(procEvento)));
                }
            }
        } else if (Objects.nonNull(data.getResponse())) {
            log.warn(data.getResponse().getXMotivo());
        }
    }


    public abstract NfceSubstituteCancelStorage getStorage();
}
