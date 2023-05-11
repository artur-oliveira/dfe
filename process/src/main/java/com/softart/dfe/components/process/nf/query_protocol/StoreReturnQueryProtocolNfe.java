package com.softart.dfe.components.process.nf.query_protocol;

import br.inf.portalfiscal.nfe.send.TConsSitNFe;
import br.inf.portalfiscal.nfe.send.TRetConsSitNFe;
import com.softart.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import com.softart.dfe.exceptions.ProcessException;
import com.softart.dfe.interfaces.process.AfterRequest;
import com.softart.dfe.interfaces.process.nf.query_protocol.AfterQueryProtocol;
import com.softart.dfe.interfaces.storage.nf.common.NfQueryProtocolStorage;
import com.softart.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreReturnQueryProtocolNfe implements AfterQueryProtocol {

    @Override
    public <T extends AfterRequest<TConsSitNFe, TRetConsSitNFe>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.response())) {
            if (Objects.nonNull(getStorage()))
                getStorage().storeRetQueryProtocol(new XMLStore<>(data.response(), data.config(), NfMarshallerFactory.getInstance().returnQueryProtocolNfe(data.response())));
        } else {
            log.warn(Objects.requireNonNull(data.response()).getXMotivo());
        }

    }

    public abstract NfQueryProtocolStorage getStorage();
}
