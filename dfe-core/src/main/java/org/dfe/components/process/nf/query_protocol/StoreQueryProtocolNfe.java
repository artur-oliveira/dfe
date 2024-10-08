package org.dfe.components.process.nf.query_protocol;

import br.inf.portalfiscal.nfe.send.TConsSitNFe;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.nf.query_protocol.BeforeQueryProtocol;
import org.dfe.interfaces.storage.nf.common.NfQueryProtocolStorage;
import org.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreQueryProtocolNfe implements BeforeQueryProtocol {

    @Override
    public <T extends BeforeRequest<TConsSitNFe>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request())) if (Objects.nonNull(getStorage()))
            getStorage().storeEnvQueryProtocol(new XMLStore<>(data.request(), data.config(), NfMarshallerFactory.getInstance().queryProcotolNfe(data.request())));
    }

    public abstract NfQueryProtocolStorage getStorage();
}
