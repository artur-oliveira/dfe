package org.dfe.components.process.nf.authorization;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import br.inf.portalfiscal.nfe.send.TRetEnviNFe;
import lombok.extern.log4j.Log4j2;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.nf.authorization.AfterAuthorization;
import org.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

@Log4j2
public abstract class StoreProcAuthorizationNfe implements AfterAuthorization {

    @Override
    public <T extends AfterRequest<TEnviNFe, TRetEnviNFe>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request()) && Objects.nonNull(data.response())) {
            if (Objects.nonNull(data.response().getProtNFe()) && !data.request().getNFe().isEmpty()) {
                for (int i = 0; i < data.request().getNFe().size(); i++) {
                    br.inf.portalfiscal.nfe.send.TNfeProc proc = new br.inf.portalfiscal.nfe.send.ObjectFactory().createTNfeProc();
                    proc.setNFe(data.request().getNFe().get(i));
                    proc.setProtNFe(data.response().getProtNFe());
                    proc.setVersao(data.request().getNFe().get(i).getInfNFe().getVersao());
                    getStorage().storeProcNfe(new XMLStore<>(proc, data.config(), NfMarshallerFactory.getInstance().procNfe(proc)));
                }
            }
        } else {
            log.warn(Objects.requireNonNull(data.response()).getXMotivo());
            if (Objects.nonNull(data.response().getProtNFe()) && Objects.nonNull(data.response().getProtNFe().getInfProt()))
                log.warn(data.response().getProtNFe().getInfProt().getXMotivo());
        }
    }

    public abstract NfAuthorizationStorage getStorage();
}
