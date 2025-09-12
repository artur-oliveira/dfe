package org.dfe.components.process.nf.event;

import br.inf.portalfiscal.nfe.event_generic.TEnvEvento;
import br.inf.portalfiscal.nfe.event_generic.TProcEvento;
import br.inf.portalfiscal.nfe.event_generic.TRetEnvEvento;
import lombok.extern.log4j.Log4j2;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.nf.event.AfterEvent;
import org.dfe.interfaces.storage.nf.common.NfEventStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

@Log4j2
public abstract class StoreProcEventNfe implements AfterEvent {

    @Override
    public <T extends AfterRequest<TEnvEvento, TRetEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request()) && !data.request().getEvento().isEmpty() && Objects.nonNull(data.response()) && !data.response().getRetEvento().isEmpty()) {
            for (int i = 0; i < data.request().getEvento().size(); i++) {
                TProcEvento procEvento = new br.inf.portalfiscal.nfe.event_generic.ObjectFactory().createTProcEvento();
                procEvento.setEvento(data.request().getEvento().get(i));
                procEvento.setRetEvento(data.response().getRetEvento().get(i));
                procEvento.setVersao(procEvento.getRetEvento().getVersao());

                if (Objects.nonNull(getStorage())) {
                    getStorage().storeProcEvent(new XMLStore<>(procEvento, data.config(), NfMarshallerFactory.getInstance().procEventNfe(procEvento)));
                }
            }
        } else if (Objects.nonNull(data.response())) {
            log.warn(data.response().getXMotivo());
        }
    }


    public abstract NfEventStorage getStorage();
}
