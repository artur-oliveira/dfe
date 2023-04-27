package com.softart.dfe.components.process.nf.authorization;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import br.inf.portalfiscal.nfe.send.TRetEnviNFe;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.nf.authorization.AfterAuthorization;
import com.softart.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreProcAuthorizationNfe implements AfterAuthorization {

    @Override
    public <T extends AfterRequest<TEnviNFe, TRetEnviNFe>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.getRequest()) && Objects.nonNull(data.getResponse())) {
            if (Objects.nonNull(data.getResponse().getProtNFe()) && !data.getRequest().getNFe().isEmpty()) {
                for (int i = 0; i < data.getRequest().getNFe().size(); i++) {
                    br.inf.portalfiscal.nfe.send.TNfeProc proc = new br.inf.portalfiscal.nfe.send.ObjectFactory().createTNfeProc();
                    proc.setNFe(data.getRequest().getNFe().get(i));
                    proc.setProtNFe(data.getResponse().getProtNFe());
                    proc.setVersao(data.getRequest().getNFe().get(i).getInfNFe().getVersao());
                    getStorage().storeProcNfe(new XMLStore<>(proc, data.getConfig(), NfMarshallerFactory.getInstance().procNfe(proc)));
                }
            }
        } else {
            log.warn(Objects.requireNonNull(data.getResponse()).getXMotivo());
            if (Objects.nonNull(data.getResponse().getProtNFe()) && Objects.nonNull(data.getResponse().getProtNFe().getInfProt()))
                log.warn(data.getResponse().getProtNFe().getInfProt().getXMotivo());
        }
    }

    public abstract NfAuthorizationStorage getStorage();
}
