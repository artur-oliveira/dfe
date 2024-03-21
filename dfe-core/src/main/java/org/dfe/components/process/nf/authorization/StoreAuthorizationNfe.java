package org.dfe.components.process.nf.authorization;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import lombok.extern.log4j.Log4j2;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.BeforeRequest;
import org.dfe.interfaces.process.nf.authorization.BeforeAuthorization;
import org.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;
import org.dfe.models.internal.xml.XMLStore;

import java.util.Objects;

@Log4j2
public abstract class StoreAuthorizationNfe implements BeforeAuthorization {

    @Override
    public <T extends BeforeRequest<TEnviNFe>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.request()))
            if (Objects.nonNull(getStorage()))
                getStorage().storeEnvNfe(new XMLStore<>(data.request(), data.config(), NfMarshallerFactory.getInstance().sendNfe(data.request())));
    }

    public abstract NfAuthorizationStorage getStorage();
}
