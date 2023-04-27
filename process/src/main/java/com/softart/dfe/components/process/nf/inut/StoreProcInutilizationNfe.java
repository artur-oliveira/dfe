package com.softart.dfe.components.process.nf.inut;

import br.inf.portalfiscal.nfe.send.TInutNFe;
import br.inf.portalfiscal.nfe.send.TProcInutNFe;
import br.inf.portalfiscal.nfe.send.TRetInutNFe;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.nf.inut.AfterInut;
import com.softart.dfe.interfaces.storage.nf.NfInutStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreProcInutilizationNfe implements AfterInut {

    @Override
    public <T extends AfterRequest<TInutNFe, TRetInutNFe>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.getRequest()) && Objects.nonNull(data.getRequest().getInfInut()) && Objects.nonNull(data.getResponse()) && Objects.nonNull(data.getResponse().getInfInut())) {
            TProcInutNFe procInut = new br.inf.portalfiscal.nfe.send.ObjectFactory().createTProcInutNFe();

            procInut.setInutNFe(data.getRequest());
            procInut.setRetInutNFe(data.getResponse());
            procInut.setVersao(data.getRequest().getVersao());

            if (Objects.nonNull(getStorage()))
                getStorage().storeProcInut(new XMLStore<>(procInut, data.getConfig(), NfMarshallerFactory.getInstance().procInutNfe(procInut)));
        } else {
            log.warn(Objects.requireNonNull(data.getResponse()).getInfInut().getXMotivo());
        }
    }

    public abstract NfInutStorage getStorage();
}
