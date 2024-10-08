package org.dfe.components.process.nf.authorization;

import br.inf.portalfiscal.nfe.send.TEnviNFe;
import br.inf.portalfiscal.nfe.send.TRetEnviNFe;
import org.dfe.components.internal.xml.marshaller.NfMarshallerFactory;
import org.dfe.exceptions.ProcessException;
import org.dfe.interfaces.process.AfterRequest;
import org.dfe.interfaces.process.nf.authorization.AfterAuthorization;
import org.dfe.interfaces.storage.nf.common.NfAuthorizationStorage;
import org.dfe.models.internal.xml.XMLStore;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

@Log4j2
public abstract class StoreRetAuthorizationNfe implements AfterAuthorization {

    @Override
    public <T extends AfterRequest<TEnviNFe, TRetEnviNFe>> void process(T data) throws ProcessException {
        if (Objects.nonNull(data.response())) {
            if (Objects.nonNull(getStorage()))
                getStorage().storeRetNfe(new XMLStore<>(data.response(), data.config(), NfMarshallerFactory.getInstance().returnEnviNfe(data.response())));
        }
    }


    public abstract NfAuthorizationStorage getStorage();
}
