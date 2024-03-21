package org.dfe.components.process.nf.cancel;

import br.inf.portalfiscal.nfe.event_cancel.TEnvEvento;
import br.inf.portalfiscal.nfe.event_cancel.TRetEnvEvento;
import br.inf.portalfiscal.nfe.event_cancel.TRetEvento;
import lombok.extern.log4j.Log4j2;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.nf.cancel.AfterCancel;
import org.dfe.interfaces.storage.nf.common.NfCancelStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;
import java.util.Optional;

@Log4j2
public abstract class StoreRetCancelNfe implements AfterCancel {

    @Override
    public <T extends AfterRequest<TEnvEvento, TRetEnvEvento>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.response()) && !data.response().getRetEvento().isEmpty()) {
            for (int i = 0; i < data.response().getRetEvento().size(); i++) {
                TRetEvento o = data.response().getRetEvento().get(i);
                o.getInfEvento().setChNFe(Optional.ofNullable(o.getInfEvento().getChNFe()).orElse(data.request().getEvento().get(i).getInfEvento().getChNFe()));
                o.getInfEvento().setTpEvento(Optional.ofNullable(o.getInfEvento().getTpEvento()).orElse(data.request().getEvento().get(i).getInfEvento().getTpEvento()));
                o.getInfEvento().setNSeqEvento(Optional.ofNullable(o.getInfEvento().getNSeqEvento()).orElse(data.request().getEvento().get(i).getInfEvento().getNSeqEvento()));
            }

            if (Objects.nonNull(getStorage()))
                getStorage().storeRetCancel(new XMLStore<>(data.response(), data.config(), NfMarshallerFactory.getInstance().returnCancelNfe(data.response())));
        } else if (Objects.nonNull(data.response())) {
            log.warn(data.response().getXMotivo());
        }
    }

    public abstract NfCancelStorage getStorage();
}
