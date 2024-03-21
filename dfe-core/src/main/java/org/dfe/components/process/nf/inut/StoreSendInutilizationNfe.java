package org.dfe.components.process.nf.inut;

import br.inf.portalfiscal.nfe.send.TInutNFe;
import lombok.extern.log4j.Log4j2;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.nf.inut.BeforeInut;
import org.dfe.interfaces.storage.nf.NfInutStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

@Log4j2
public abstract class StoreSendInutilizationNfe implements BeforeInut {

    @Override
    public <T extends BeforeRequest<TInutNFe>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request())) if (Objects.nonNull(getStorage()))
            getStorage().storeEnvInut(new XMLStore<>(data.request(), data.config(), NfMarshallerFactory.getInstance().inutNfe(data.request())));

    }

    public abstract NfInutStorage getStorage();
}
