package org.dfe.components.process.nf.manifestation;

import br.inf.portalfiscal.nfe.event_manifestation.TEnvEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TRetEnvEvento;
import br.inf.portalfiscal.nfe.event_manifestation.TretEvento;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.nf.manifestation.AfterManifestation;
import org.dfe.interfaces.storage.nf.NfeManifestationStorage;
import org.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;
import java.util.Optional;

@Log4j2
public abstract class StoreRetManifestationNfe implements AfterManifestation {

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
                getStorage().storeRetManifestation(new XMLStore<>(data.response(), data.config(), NfMarshallerFactory.getInstance().returnManifestationNfe(data.response())));
        } else {
            log.warn(data.response().getXMotivo());
        }
    }

    public abstract NfeManifestationStorage getStorage();
}
